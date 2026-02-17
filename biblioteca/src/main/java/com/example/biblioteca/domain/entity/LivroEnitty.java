package com.example.biblioteca.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class LivroEnitty {
    private Long livroId;
    private String titulo;
    private String autor;
    private String genero;
    private LocalDate dataPublicacao;
    private Double preco;
}
