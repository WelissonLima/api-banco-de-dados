package com.br.lima.atividade.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_contrato_aluguel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContratoAluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_contrato;
    private Double vl_aluguel;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dt_contrato;
    
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dt_inicio;
    
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dt_fim;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_inquilino")
    private Inquilino inquilino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_imovel")
    private Imovel imovel;

    @OneToMany(mappedBy = "aluguel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pagamento> pagamentos;

    public ContratoAluguel() {
    }

    public ContratoAluguel(Long cd_contrato, LocalDate dt_contrato, LocalDate dt_inicio, LocalDate dt_fim, Double vl_aluguel,
            Imovel imovel, Inquilino inquilino, List<Pagamento> pagamentos) {
        this.cd_contrato = cd_contrato;
        this.dt_contrato = dt_contrato;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.vl_aluguel = vl_aluguel;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.pagamentos = pagamentos;
    }

    public ContratoAluguel(LocalDate dt_contrato, LocalDate dt_inicio, LocalDate dt_fim, Double vl_aluguel, Imovel imovel,
            Inquilino inquilino, List<Pagamento> pagamentos) {
        this.dt_contrato = dt_contrato;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.vl_aluguel = vl_aluguel;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.pagamentos = pagamentos;
    }

    public Long getCd_contrato() {
        return cd_contrato;
    }

    public void setCd_contrato(Long cd_contrato) {
        this.cd_contrato = cd_contrato;
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

    public Double getVl_aluguel() {
        return vl_aluguel;
    }

    public void setVl_aluguel(Double vl_aluguel) {
        this.vl_aluguel = vl_aluguel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

}
