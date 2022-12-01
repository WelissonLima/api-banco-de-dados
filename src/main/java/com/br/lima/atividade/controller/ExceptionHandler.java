package com.br.lima.atividade.controller;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.lima.atividade.model.ResponseError;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ResponseError> handleEntityNotFound(EntityNotFoundException ex) {
        ResponseError responseError  = new ResponseError();

        responseError.setStatus(HttpStatus.NOT_FOUND);
        responseError.setMensagem(ex.getMessage());
        responseError.setTimestamp(LocalDateTime.now());

        return buildResponseEntity(responseError);
    }

    private ResponseEntity<ResponseError> buildResponseEntity(ResponseError responseError) {
        return new ResponseEntity<>(responseError, responseError.getStatus());
    }
}
