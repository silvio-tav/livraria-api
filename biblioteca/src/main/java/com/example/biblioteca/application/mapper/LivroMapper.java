package com.example.biblioteca.application.mapper;

import com.example.biblioteca.application.dto.LivroRequestDto;
import com.example.biblioteca.application.dto.LivroResponseDto;
import com.example.biblioteca.domain.entity.LivroEnitty;
import com.example.biblioteca.infra.persistence.entity.LivrariaJpaEntity;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    private LivrariaMapper livrariaMapper;

    public LivroMapper(LivrariaMapper livrariaMapper) {
        this.livrariaMapper = livrariaMapper;
    }

    public LivroResponseDto entityToResponse(LivroEnitty livroEnitty){
        return LivroResponseDto.builder()
                .id(livroEnitty.getLivroId())
                .preco(livroEnitty.getPreco())
                .autor(livroEnitty.getAutor())
                .dataPublicacao(livroEnitty.getDataPublicacao())
                .genero(livroEnitty.getGenero())
                .titulo(livroEnitty.getTitulo())
                .livraria(livrariaMapper.entityToResponse(livroEnitty.getLivraria()))
                .build();
    }

    public LivroEnitty requestToEntity(LivroRequestDto livroRequestDto){
        return LivroEnitty.builder()
                .titulo(livroRequestDto.getTitulo())
                .preco(livroRequestDto.getPreco())
                .genero(livroRequestDto.getGenero())
                .dataPublicacao(livroRequestDto.getDataPublicacao())
                .autor(livroRequestDto.getAutor())
                .build();
    }

    public LivroEnitty jpaToEntity(LivroJpaEntity livroJpaEntity){
        return LivroEnitty.builder()
                .livroId(livroJpaEntity.getLivroId())
                .livraria(livrariaMapper.jpaToEntity(livroJpaEntity.getLivraria()))
                .autor(livroJpaEntity.getAutor())
                .preco(livroJpaEntity.getPreco())
                .titulo(livroJpaEntity.getTitulo())
                .dataPublicacao(livroJpaEntity.getDataPublicacao())
                .genero(livroJpaEntity.getGenero())
                .build();
    }
}
