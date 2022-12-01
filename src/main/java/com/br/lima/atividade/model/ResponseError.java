package com.br.lima.atividade.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseError {
    private HttpStatus status;
    private String mensagem;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ResponseError() {
        timestamp = LocalDateTime.now();
    }

    public ResponseError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ResponseError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.mensagem = "Unexpected error";
    }

    public ResponseError(HttpStatus status, String mensagem, Throwable ex) {
        this();
        this.status = status;
        this.mensagem = mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
