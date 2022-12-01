package com.br.lima.atividade.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_dados_bancarios")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DadosBancarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_dados_bancarios;
    private String banco;
    private String agencia;
    private String conta;

    @OneToOne(mappedBy = "dadosBancarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Proprietario proprietario;

    public DadosBancarios() {
    }

    public DadosBancarios(Long cd_dados_bancarios, String banco, String agencia, String conta,
            Proprietario proprietario) {
        this.cd_dados_bancarios = cd_dados_bancarios;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.proprietario = proprietario;
    }

    public DadosBancarios(String banco, String agencia, String conta, Proprietario proprietario) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.proprietario = proprietario;
    }

    public Long getCd_dados_bancarios() {
        return cd_dados_bancarios;
    }

    public void setCd_dados_bancarios(Long cd_dados_bancarios) {
        this.cd_dados_bancarios = cd_dados_bancarios;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

}
