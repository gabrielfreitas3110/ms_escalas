package com.example.ms_escalas.Escalas.service.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg){
        super(msg);
    }

}