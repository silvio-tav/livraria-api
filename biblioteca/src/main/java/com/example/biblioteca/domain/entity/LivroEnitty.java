package com.example.biblioteca.domain.entity;

import com.example.biblioteca.domain.enums.GeneroLivro;
import com.example.biblioteca.infra.persistence.entity.LivrariaJpaEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class LivroEnitty {
    private Long livroId;
    private String titulo;
    private String autor;
    private GeneroLivro genero;
    private LocalDate dataPublicacao;
    private Double preco;
    private LivrariaEntity livraria;
}
