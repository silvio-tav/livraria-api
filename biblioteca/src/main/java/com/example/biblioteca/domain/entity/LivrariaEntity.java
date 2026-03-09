package com.example.biblioteca.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class LivrariaEntity {
    private Long livrariaId;
    private String nomeLivraria;
    private String rua;
    private String numero;
    private String cep;
    private List<LivroEnitty> livros;
}
