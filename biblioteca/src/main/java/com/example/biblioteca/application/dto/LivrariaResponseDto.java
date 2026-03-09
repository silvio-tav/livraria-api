package com.example.biblioteca.application.dto;

import lombok.Builder;

@Builder
public class LivrariaResponseDto {
    private Long id;
    private String nomeLivraria;
    private String rua;
    private String numero;
    private String cep;
}
