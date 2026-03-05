package com.example.biblioteca.domain.entity;

import com.example.biblioteca.domain.enums.GeneroLivro;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class LivroEnitty {
    private Long livroId;
    private String titulo;
    private String autor;
    private GeneroLivro genero;
    private LocalDate dataPublicacao;
    private Double preco;
}
