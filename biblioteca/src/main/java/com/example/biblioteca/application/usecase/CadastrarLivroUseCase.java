package com.example.biblioteca.application.usecase;

import com.example.biblioteca.domain.entity.LivroEnitty;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import com.example.biblioteca.infra.persistence.mapper.LivroEntityMapper;
import com.example.biblioteca.infra.persistence.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarLivroUseCase {
    private LivroRepository repository;
    private LivroEntityMapper livroEntityMapper;

    public CadastrarLivroUseCase(LivroRepository repository, LivroEntityMapper livroEntityMapper) {
        this.repository = repository;
        this.livroEntityMapper = livroEntityMapper;
    }

    public LivroEnitty cadastrarLivro(LivroEnitty livroEnitty) {
        LivroJpaEntity saved = repository.save(livroEntityMapper.toJpaEnitity(livroEnitty));
        return livroEntityMapper.toEntity(saved);
    }
}
