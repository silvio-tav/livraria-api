package com.example.biblioteca.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class LivroResponseDto {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private LocalDate dataPublicacao;
    private Double preco;
}
