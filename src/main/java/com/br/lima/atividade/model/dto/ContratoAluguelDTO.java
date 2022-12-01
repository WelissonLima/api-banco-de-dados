package com.br.lima.atividade.model.dto;

import java.time.LocalDate;

import com.br.lima.atividade.model.entity.ContratoAluguel;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ContratoAluguelDTO {

    private Long cd_contrato;
    private Double vl_aluguel;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dt_contrato;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dt_inicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dt_fim;

    private Long cd_inquilino;

    private Long cd_imovel;

    public ContratoAluguelDTO() {
    }

    public ContratoAluguelDTO(Long cd_contrato, Double vl_aluguel, LocalDate dt_contrato, LocalDate dt_inicio,
            LocalDate dt_fim, Long cd_inquilino, Long cd_imovel) {
        this.cd_contrato = cd_contrato;
        this.vl_aluguel = vl_aluguel;
        this.dt_contrato = dt_contrato;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.cd_inquilino = cd_inquilino;
        this.cd_imovel = cd_imovel;
    }

    public Long getCd_contrato() {
        return cd_contrato;
    }

    public void setCd_contrato(Long cd_contrato) {
        this.cd_contrato = cd_contrato;
    }

    public Double getVl_aluguel() {
        return vl_aluguel;
    }

    public void setVl_aluguel(Double vl_aluguel) {
        this.vl_aluguel = vl_aluguel;
    }

    public LocalDate getDt_contrato() {
        return dt_contrato;
    }

    public void setDt_contrato(LocalDate dt_contrato) {
        this.dt_contrato = dt_contrato;
    }

    public LocalDate getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(LocalDate dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public LocalDate getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(LocalDate dt_fim) {
        this.dt_fim = dt_fim;
    }

    public Long getCd_inquilino() {
        return cd_inquilino;
    }

    public void setCd_inquilino(Long cd_inquilino) {
        this.cd_inquilino = cd_inquilino;
    }

    public Long getCd_imovel() {
        return cd_imovel;
    }

    public void setCd_imovel(Long cd_imovel) {
        this.cd_imovel = cd_imovel;
    }

    public ContratoAluguel toContratoAluguel(){
        ContratoAluguel aluguel = new ContratoAluguel();
        aluguel.setCd_contrato(this.cd_contrato);
        aluguel.setVl_aluguel(this.vl_aluguel);
        aluguel.setDt_contrato(this.dt_contrato);
        aluguel.setDt_inicio(this.dt_inicio);
        aluguel.setDt_fim(this.dt_fim);

        return aluguel;
    }

}
