package com.example.biblioteca.application.usecase;

import com.example.biblioteca.application.mapper.LivrariaMapper;
import com.example.biblioteca.domain.entity.LivroEnitty;
import com.example.biblioteca.infra.persistence.entity.LivrariaJpaEntity;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import com.example.biblioteca.infra.persistence.mapper.LivroEntityMapper;
import com.example.biblioteca.infra.persistence.repository.LivrariaRepository;
import com.example.biblioteca.infra.persistence.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarLivroUseCase {
    private LivroRepository repository;
    private LivrariaRepository livrariaRepository;
    private LivroEntityMapper livroEntityMapper;

    public CadastrarLivroUseCase(LivroRepository repository, LivrariaRepository livrariaRepository, LivroEntityMapper livroEntityMapper) {
        this.repository = repository;
        this.livrariaRepository = livrariaRepository;
        this.livroEntityMapper = livroEntityMapper;
    }

    public LivroEnitty cadastrarLivro(LivroEnitty livroEnitty, Long livrariaId) {
        Optional<LivrariaJpaEntity> byId = livrariaRepository.findById(livrariaId);
        if (byId.isPresent()) {
            LivroJpaEntity jpaEnitity = livroEntityMapper.toJpaEnitity(livroEnitty);
            jpaEnitity.setLivraria(byId.get());
            return livroEntityMapper.toEntity(repository.save(jpaEnitity));
        }
        throw new RuntimeException("Livraria com id "+livrariaId.toString()+" nao encontrada");
    }
}
