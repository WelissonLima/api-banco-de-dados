package com.br.lima.atividade.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_proprietario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_proprietario;
    private String nm_proprietario;
    private String cpf;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_dados_bancarios")
    private DadosBancarios dadosBancarios;

    @OneToOne(mappedBy = "proprietario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Imovel imovel;

    public Proprietario() {
    }

    public Proprietario(Long cd_proprietario, String nm_proprietario, String cpf, DadosBancarios dadosBancarios,
            Imovel imovel) {
        this.cd_proprietario = cd_proprietario;
        this.nm_proprietario = nm_proprietario;
        this.cpf = cpf;
        this.dadosBancarios = dadosBancarios;
        this.imovel = imovel;
    }

    public Proprietario(String nm_proprietario, String cpf, DadosBancarios dadosBancarios, Imovel imovel) {
        this.nm_proprietario = nm_proprietario;
        this.cpf = cpf;
        this.dadosBancarios = dadosBancarios;
        this.imovel = imovel;
    }

    public Long getCd_proprietario() {
        return cd_proprietario;
    }

    public void setCd_proprietario(Long cd_proprietario) {
        this.cd_proprietario = cd_proprietario;
    }

    public String getNm_proprietario() {
        return nm_proprietario;
    }

    public void setNm_proprietario(String nm_proprietario) {
        this.nm_proprietario = nm_proprietario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public DadosBancarios getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(DadosBancarios dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

}
