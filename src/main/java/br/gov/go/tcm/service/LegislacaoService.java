package br.gov.go.tcm.service;

import br.gov.go.tcm.dto.LegislacaoDTO;
import br.gov.go.tcm.service.consumer_api.LegislacaoConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegislacaoService extends BaseService<LegislacaoDTO> {

    @Autowired
    private LegislacaoConsumer consumer;

    public Page<LegislacaoDTO> listarLegislacoesPaginado(Integer codigoIbge, Pageable pageable) {
        List<LegislacaoDTO> lista = consumer.listarLegislacoes(codigoIbge);
        return paginador(lista,pageable);
    }
    public List<LegislacaoDTO> listarLegislacoes(Integer codigoIbge) {
        return consumer.listarLegislacoes(codigoIbge);
    }
}
