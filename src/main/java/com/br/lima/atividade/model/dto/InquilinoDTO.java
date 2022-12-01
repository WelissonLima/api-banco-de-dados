package com.br.lima.atividade.model.dto;

public class InquilinoDTO {

    private Long cd_inquilino;
    private String nm_inquilino;
    private String cpf;

    public InquilinoDTO() {
    }

    public InquilinoDTO(Long cd_inquilino, String nm_inquilino, String cpf) {
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
