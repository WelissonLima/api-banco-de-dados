package com.br.lima.atividade.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_pagamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_pagamento;
    private String ds_mes_ano;
    private Double vl_pago;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dt_pagamento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_contrato")
    @JsonIgnore
    private ContratoAluguel aluguel;

    public Pagamento() {
    }

    public Pagamento(String ds_mes_ano, Double vl_pago, Date dt_pagamento, ContratoAluguel aluguel) {
        this.ds_mes_ano = ds_mes_ano;
        this.vl_pago = vl_pago;
        this.dt_pagamento = dt_pagamento;
        this.aluguel = aluguel;
    }

    public Pagamento(Long cd_pagamento, String ds_mes_ano, Double vl_pago, Date dt_pagamento, ContratoAluguel aluguel) {
        this.cd_pagamento = cd_pagamento;
        this.ds_mes_ano = ds_mes_ano;
        this.vl_pago = vl_pago;
        this.dt_pagamento = dt_pagamento;
        this.aluguel = aluguel;
    }

    public Long getCd_pagamento() {
        return cd_pagamento;
    }

    public void setCd_pagamento(Long cd_pagamento) {
        this.cd_pagamento = cd_pagamento;
    }

    public String getDs_mes_ano() {
        return ds_mes_ano;
    }

    public void setDs_mes_ano(String ds_mes_ano) {
        this.ds_mes_ano = ds_mes_ano;
    }

    public Double getVl_pago() {
        return vl_pago;
    }

    public void setVl_pago(Double vl_pago) {
        this.vl_pago = vl_pago;
    }

    public Date getDt_pagamento() {
        return dt_pagamento;
    }

    public void setDt_pagamento(Date dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    public ContratoAluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(ContratoAluguel aluguel) {
        this.aluguel = aluguel;
    }

}
