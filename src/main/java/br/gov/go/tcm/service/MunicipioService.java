package br.gov.go.tcm.service;

import br.gov.go.tcm.dto.MunicipioDTO;
import br.gov.go.tcm.service.consumer_api.MunicipioConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MunicipioService extends BaseService<MunicipioDTO> {

    @Autowired
    private MunicipioConsumer consumer;


    public Page<MunicipioDTO> listarPaginado(String query, Pageable pageable) {
        List<MunicipioDTO> municipios = Objects.isNull(query) ? listarTodos(): pesquisarPorQuery(query);

        return paginador(municipios, pageable);
    }

    public List<MunicipioDTO> listarTodos() {
        return consumer.listarTodos();
    }

    public List<MunicipioDTO> pesquisarPorQuery(String query) {
        return listarTodos()
                .stream()
                .filter(m -> m.getMunicipio().toUpperCase().contains(query.toUpperCase())
                        || m.getCodigoIBGE().toString().contains(query))
                .collect(Collectors.toList());
    }

    public Optional<MunicipioDTO> buscarPorCodigoIbge(Integer codigoIbge) {
        return consumer.listarTodos()
                .stream()
                .filter(m -> m.getCodigoIBGE().equals(codigoIbge))
                .findFirst();

    }


}
