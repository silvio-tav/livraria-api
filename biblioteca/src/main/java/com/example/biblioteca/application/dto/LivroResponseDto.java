package com.example.biblioteca.application.dto;

import com.example.biblioteca.domain.enums.GeneroLivro;
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
    private GeneroLivro genero;
    private LocalDate dataPublicacao;
    private Double preco;
    private LivrariaResponseDto livraria;
}
