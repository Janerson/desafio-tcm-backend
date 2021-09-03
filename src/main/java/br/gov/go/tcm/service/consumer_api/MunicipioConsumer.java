package br.gov.go.tcm.service.consumer_api;

import br.gov.go.tcm.config.FeignConfig;
import br.gov.go.tcm.dto.MunicipioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "municipio-consumer",url = "${url-municipios}", configuration = FeignConfig.class)
public interface MunicipioConsumer {

    @GetMapping("/")
    List<MunicipioDTO> listarTodos();
}
