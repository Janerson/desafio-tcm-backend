package br.gov.go.tcm.controllers;

import br.gov.go.tcm.dto.LegislacaoDTO;
import br.gov.go.tcm.dto.MunicipioDTO;
import br.gov.go.tcm.service.LegislacaoService;
import br.gov.go.tcm.service.MunicipioService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("municipios")
public class MunicipioContoller {


    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private LegislacaoService legislacaoService;


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Municípios.")
    })
    @GetMapping(path = "/listar", produces = "application/json")
    public Page<MunicipioDTO> listarPaginado(@RequestParam String query, Pageable pageable) {
        return municipioService.listarPaginado(query, pageable);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Município de acordo com o código IBGE.")
    })
    @GetMapping(path = "/{codigoIbge}", produces = "application/json")
    public MunicipioDTO buscarPorCodigoIbge(@PathVariable("codigoIbge") Integer codigoIbge) {
        return municipioService.buscarPorCodigoIbge(codigoIbge)
                .orElseThrow(() -> new RuntimeException("Município não localizado."));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todas as legislações do Município, através de seu código IBGE.")
    })
    @GetMapping(value = "/{codigoIbge}/legislacoes", produces = "application/json")
    public Page<LegislacaoDTO> listarLegislacoes(@PathVariable("codigoIbge") Integer codigoIbge, @RequestParam String query, Pageable pageable) {
        return legislacaoService.listarLegislacoesPaginado(codigoIbge, query, pageable);
    }

}
