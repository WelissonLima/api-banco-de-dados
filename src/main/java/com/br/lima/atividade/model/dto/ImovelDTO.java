package com.br.lima.atividade.model.dto;

import com.br.lima.atividade.model.entity.Endereco;
import com.br.lima.atividade.model.entity.Imovel;
import com.br.lima.atividade.model.entity.TipoImovel;

public class ImovelDTO {

    private Long cd_imovel;
    private Integer qtd_quartos;
    private Integer qtd_banheiros;
    private Endereco endereco;
    private TipoImovel tipoImovel;
    private Long cd_proprietario;

    public ImovelDTO() {
    }

    public ImovelDTO(Long cd_imovel, Integer qtd_quartos, Integer qtd_banheiros, Endereco endereco,
            TipoImovel tipoImovel, Long cd_proprietario) {
        this.cd_imovel = cd_imovel;
        this.qtd_quartos = qtd_quartos;
        this.qtd_banheiros = qtd_banheiros;
        this.endereco = endereco;
        this.tipoImovel = tipoImovel;
        this.cd_proprietario = cd_proprietario;
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

    public Long getCd_proprietario() {
        return cd_proprietario;
    }

    public void setCd_proprietario(Long cd_proprietario) {
        this.cd_proprietario = cd_proprietario;
    }

    public Imovel toImovel(){
        Imovel imovel = new Imovel();

        imovel.setQtd_banheiros(qtd_banheiros);
        imovel.setQtd_quartos(qtd_quartos);
        imovel.setEndereco(endereco);
        imovel.setTipoImovel(tipoImovel);

        return imovel;
    }
}
