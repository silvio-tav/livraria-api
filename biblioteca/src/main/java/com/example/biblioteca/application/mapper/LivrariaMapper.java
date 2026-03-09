package com.example.biblioteca.application.mapper;

import com.example.biblioteca.application.dto.LivrariaResponseDto;
import com.example.biblioteca.domain.entity.LivrariaEntity;
import com.example.biblioteca.infra.persistence.entity.LivrariaJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class LivrariaMapper {
    private LivroMapper livroMapper;

    public LivrariaMapper(LivroMapper livroMapper) {
        this.livroMapper = livroMapper;
    }

    public LivrariaResponseDto entityToResponse(LivrariaEntity livrariaEntity){
        return LivrariaResponseDto.builder()
                .cep(livrariaEntity.getCep())
                .rua(livrariaEntity.getRua())
                .nomeLivraria(livrariaEntity.getNomeLivraria())
                .numero(livrariaEntity.getNumero())
                .id(livrariaEntity.getLivrariaId())
                .build();
    }

    public LivrariaEntity jpaToEntity(LivrariaJpaEntity livrariaJpaEntity){
        return LivrariaEntity.builder()
                .livros(livrariaJpaEntity.getLivros().stream().map(livroMapper::jpaToEntity).toList())
                .rua(livrariaJpaEntity.getRua())
                .cep(livrariaJpaEntity.getCep())
                .nomeLivraria(livrariaJpaEntity.getNomeLivraria())
                .numero(livrariaJpaEntity.getNumero())
                .livrariaId(livrariaJpaEntity.getLivrariaId())
                .build();
    }
}
