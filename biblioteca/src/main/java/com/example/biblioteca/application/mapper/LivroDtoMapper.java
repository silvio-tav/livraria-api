package com.example.biblioteca.application.mapper;

import com.example.biblioteca.application.dto.LivroRequestDto;
import com.example.biblioteca.application.dto.LivroResponseDto;
import com.example.biblioteca.domain.entity.LivroEnitty;
import org.springframework.stereotype.Component;

@Component
public class LivroDtoMapper {
    public LivroResponseDto entityToResponse(LivroEnitty livroEnitty){
        return LivroResponseDto.builder()
                .id(livroEnitty.getLivroId())
                .preco(livroEnitty.getPreco())
                .autor(livroEnitty.getAutor())
                .dataPublicacao(livroEnitty.getDataPublicacao())
                .genero(livroEnitty.getGenero())
                .titulo(livroEnitty.getTitulo())
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
}
