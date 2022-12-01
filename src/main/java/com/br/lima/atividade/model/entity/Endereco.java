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
@Table(name = "tb_endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_endereco;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String complemento;
    private String cep;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Imovel imovel;


    public Endereco() {
    }

    public Endereco(String uf, String cidade, String bairro, String logradouro, String complemento, String cep) {
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco(Long cd_endereco, String uf, String cidade, String bairro, String logradouro, String complemento,
            String cep) {
        this.cd_endereco = cd_endereco;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Long getCd_endereco() {
        return cd_endereco;
    }

    public void setCd_endereco(Long cd_endereco) {
        this.cd_endereco = cd_endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
