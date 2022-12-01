package com.br.lima.atividade.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tipo_imovel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_tp_imovel;
    private String tp_imovel;

    @OneToOne(mappedBy = "tipoImovel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Imovel imovel;

    public TipoImovel() {
    }

    public TipoImovel(String tp_imovel) {
        this.tp_imovel = tp_imovel;
    }

    public TipoImovel(Long cd_tp_iimovel, String tp_imovel) {
        this.cd_tp_imovel = cd_tp_iimovel;
        this.tp_imovel = tp_imovel;
    }

    public Long getCd_tp_imovel() {
        return cd_tp_imovel;
    }

    public void setCd_tp_imovel(Long cd_tp_iimovel) {
        this.cd_tp_imovel = cd_tp_iimovel;
    }

    public String getTp_imovel() {
        return tp_imovel;
    }

    public void setTp_imovel(String tp_imovel) {
        this.tp_imovel = tp_imovel;
    }
}
