package com.example.biblioteca.application.dto;

import com.example.biblioteca.domain.enums.GeneroLivro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFiltroDTO {
    private String titulo;
    private String autor;
    private GeneroLivro genero;
    private Double precoMin;
    private Double precoMax;
}
