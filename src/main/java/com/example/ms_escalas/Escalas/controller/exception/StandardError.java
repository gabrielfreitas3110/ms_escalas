package com.example.ms_escalas.Escalas.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private Integer status;
    private String msg;
    private  String timestamp;
}