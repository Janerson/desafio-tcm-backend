package br.gov.go.tcm.controllers;

import br.gov.go.tcm.dto.LegislacaoDTO;
import br.gov.go.tcm.dto.MunicipioDTO;
import br.gov.go.tcm.service.LegislacaoService;
import br.gov.go.tcm.service.MunicipioService;
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


    @GetMapping("/listar-paginado")
    public Page<MunicipioDTO> listarPaginado(@RequestParam String query, Pageable pageable) {
        return municipioService.listarPaginado(query,pageable);
    }

    @GetMapping("/{codigoIbge}")
    public MunicipioDTO buscarPorCodigoIbge(@PathVariable("codigoIbge") Integer codigoIbge) {
        return municipioService.buscarPorCodigoIbge(codigoIbge)
                .orElseThrow(() -> new RuntimeException("Município não localizado."));
    }

    @GetMapping("/{codigoIbge}/legislacoes/paginado")
    public Page<LegislacaoDTO> listarLegislacoes(@PathVariable("codigoIbge") Integer codigoIbge, @RequestParam String query, Pageable pageable) {
        return legislacaoService.listarLegislacoesPaginado(codigoIbge,query,pageable);
    }

}
