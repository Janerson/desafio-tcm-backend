package br.gov.go.tcm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseService<T> {

    public Page<T> paginador(List<T> lista, Pageable pageable) {
        if (lista == null) {
            throw new IllegalArgumentException("Lista não pode ser nula.");
        }
        int inicioPagina = pageable.getPageNumber() * pageable.getPageSize();
        if (inicioPagina > lista.size()) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }
        int fimPagina = Math.min(inicioPagina + pageable.getPageSize(), lista.size());
        return new PageImpl<>(
                lista.subList(inicioPagina, fimPagina),
                pageable,
                lista.size());
    }

    public boolean filtrar(String query, String... campo) {
        return Arrays.stream(campo).anyMatch(s -> normalizer(s).contains(normalizer(query)));
    }

    public String normalizer(String s){
        String r = Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toUpperCase();
        return r;
    }
}
