package com.example.biblioteca.infra.persistence.mapper;

import com.example.biblioteca.domain.entity.LivroEnitty;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class LivroEntityMapper {
    public LivroJpaEntity toJpaEnitity(LivroEnitty livroEnitty){
        return LivroJpaEntity.builder()
                .preco(livroEnitty.getPreco())
                .autor(livroEnitty.getAutor())
                .dataPublicacao(livroEnitty.getDataPublicacao())
                .genero(livroEnitty.getGenero())
                .titulo(livroEnitty.getTitulo())
                .build();
    }

    public LivroEnitty toEntity(LivroJpaEntity livroJpaEntity){
        return LivroEnitty.builder()
                .livroId(livroJpaEntity.getLivroId())
                .autor(livroJpaEntity.getAutor())
                .dataPublicacao(livroJpaEntity.getDataPublicacao())
                .genero(livroJpaEntity.getGenero())
                .preco(livroJpaEntity.getPreco())
                .titulo(livroJpaEntity.getTitulo())
                .livraria(livroJpaEntity.getLivraria())
                .build();
    }
}
