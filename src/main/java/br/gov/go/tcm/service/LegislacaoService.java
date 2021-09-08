package br.gov.go.tcm.service;

import br.gov.go.tcm.dto.LegislacaoDTO;
import br.gov.go.tcm.service.consumer_api.LegislacaoConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LegislacaoService extends BaseService<LegislacaoDTO> {

    @Autowired
    private LegislacaoConsumer consumer;

    public Page<LegislacaoDTO> listarLegislacoesPaginado(Integer codigoIbge, String query, Pageable pageable) {
        return paginador(listarLegislacoesQuery(codigoIbge, query), pageable);
    }

    public List<LegislacaoDTO> listarLegislacoesQuery(Integer codigoIbge, String query) {
        return consumer.listarLegislacoes(codigoIbge)
                .stream()
                .filter(l -> filtrar(query,
                        l.getRepresentante(),
                        l.getAnoNorma().toString(),
                        l.getDataEnvio(),
                        l.getUnidadeGestora(),
                        l.getTipoNorma(),
                        l.getDetalhamentoNorma(),
                        l.getSituacaoEnvio(),
                        l.getNumeroNorma().toString()))
                .collect(Collectors.toList());

    }
}
