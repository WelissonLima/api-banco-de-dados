package com.br.lima.atividade.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_inquilino")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_inquilino;
    private String nm_inquilino;
    private String cpf;

    @OneToMany(mappedBy = "inquilino", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContratoAluguel> alugueis;

    public Inquilino() {
    }

    public Inquilino(String nm_inquilino, String cpf) {
        this.nm_inquilino = nm_inquilino;
        this.cpf = cpf;
    }

    public Inquilino(Long cd_inquilino, String nm_inquilino, String cpf) {
        this.cd_inquilino = cd_inquilino;
        this.nm_inquilino = nm_inquilino;
        this.cpf = cpf;
    }

    public Long getCd_inquilino() {
        return cd_inquilino;
    }

    public void setCd_inquilino(Long cd_inquilino) {
        this.cd_inquilino = cd_inquilino;
    }

    public String getNm_inquilino() {
        return nm_inquilino;
    }

    public void setNm_inquilino(String nm_inquilino) {
        this.nm_inquilino = nm_inquilino;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
