package com.br.lima.atividade.model.dto;

import java.util.Date;

import com.br.lima.atividade.model.entity.Pagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PagamentoDTO {

    private Long cd_pagamento;
    private String ds_mes_ano;
    private Double vl_pago;
    
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dt_pagamento;
    
    private Long cd_contrato;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long cd_pagamento, String ds_mes_ano, Double vl_pago, Date dt_pagamento, Long cd_contrato) {
        this.cd_pagamento = cd_pagamento;
        this.ds_mes_ano = ds_mes_ano;
        this.vl_pago = vl_pago;
        this.dt_pagamento = dt_pagamento;
        this.cd_contrato = cd_contrato;
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

    public Long getCd_contrato() {
        return cd_contrato;
    }

    public void setCd_contrato(Long cd_contrato) {
        this.cd_contrato = cd_contrato;
    }

    public Pagamento toPagamento(){
        Pagamento pagamento = new Pagamento();
        
        pagamento.setDs_mes_ano(ds_mes_ano);
        pagamento.setDt_pagamento(dt_pagamento);
        pagamento.setVl_pago(vl_pago);

        return pagamento;
    }

}
