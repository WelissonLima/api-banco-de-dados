package com.br.lima.atividade.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_imovel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_imovel;
    private Integer qtd_quartos;
    private Integer qtd_banheiros;      

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_tp_imovel")
    private TipoImovel tipoImovel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_proprietario")
    @JsonIgnore
    private Proprietario proprietario;

    @OneToMany(mappedBy = "imovel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ContratoAluguel> alugueis;

    public Imovel() {
    }

    public Imovel(Long cd_imovel, Integer qtd_quartos, Integer qtd_banheiros, Endereco endereco, TipoImovel tipoImovel,
            Proprietario proprietario, List<ContratoAluguel> alugueis) {
        this.cd_imovel = cd_imovel;
        this.qtd_quartos = qtd_quartos;
        this.qtd_banheiros = qtd_banheiros;
        this.endereco = endereco;
        this.tipoImovel = tipoImovel;
        this.proprietario = proprietario;
        this.alugueis = alugueis;
    }

    public Imovel(Integer qtd_quartos, Integer qtd_banheiros, Endereco endereco, TipoImovel tipoImovel,
            Proprietario proprietario, List<ContratoAluguel> alugueis) {
        this.qtd_quartos = qtd_quartos;
        this.qtd_banheiros = qtd_banheiros;
        this.endereco = endereco;
        this.tipoImovel = tipoImovel;
        this.proprietario = proprietario;
        this.alugueis = alugueis;
    }

    public Long getCd_imovel() {
        return cd_imovel;
    }

    public void setCd_imovel(Long cd_imovel) {
        this.cd_imovel = cd_imovel;
    }

    public Integer getQtd_quartos() {
        return qtd_quartos;
    }

    public void setQtd_quartos(Integer qtd_quartos) {
        this.qtd_quartos = qtd_quartos;
    }

    public Integer getQtd_banheiros() {
        return qtd_banheiros;
    }

    public void setQtd_banheiros(Integer qtd_banheiros) {
        this.qtd_banheiros = qtd_banheiros;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<ContratoAluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<ContratoAluguel> alugueis) {
        this.alugueis = alugueis;
    }

}
