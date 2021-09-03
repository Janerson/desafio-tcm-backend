package br.gov.go.tcm.service.consumer_api;

import br.gov.go.tcm.config.FeignConfig;
import br.gov.go.tcm.dto.LegislacaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "legislacao-consumer", url = "${url-legislacoes}", configuration = FeignConfig.class)
public interface LegislacaoConsumer {

    @GetMapping("/{codigoIbge}/legislacoes")
    List<LegislacaoDTO> listarLegislacoes(@PathVariable("codigoIbge") Integer codigoIbge);

}
