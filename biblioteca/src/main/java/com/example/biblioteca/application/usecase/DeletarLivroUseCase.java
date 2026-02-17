package com.example.biblioteca.application.usecase;

import com.example.biblioteca.domain.exception.LivroNaoEncontradoException;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import com.example.biblioteca.infra.persistence.mapper.LivroEntityMapper;
import com.example.biblioteca.infra.persistence.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletarLivroUseCase {
    private LivroRepository repository;

    public DeletarLivroUseCase(LivroRepository repository, LivroEntityMapper mapper) {
        this.repository = repository;
    }

    public void deletarLivro(Long livroId){
        Optional<LivroJpaEntity> byId = repository.findById(livroId);
        if (byId.isPresent()) {
            repository.delete(byId.get());
        } else {
            throw new LivroNaoEncontradoException(livroId);
        }
    }
}
