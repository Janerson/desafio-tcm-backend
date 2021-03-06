package br.gov.go.tcm.dto;

import lombok.Data;

@Data
public class LegislacaoDTO {

    private String arquivoPrincipalNorma;
    private String municipio;
    private Long anoNorma;
    private String dataEnvio;
    private String unidadeGestora;
    private String tipoNorma;
    private String detalhamentoNorma;
    private Long unidadeGestoraID;
    private String representante;
    private Long numeroNorma;
    private String ementa;
    private Long idEnvioColare;
    private String situacaoEnvio;

}
