package com.example.biblioteca.application.usecase;

import com.example.biblioteca.domain.entity.LivroEnitty;
import com.example.biblioteca.domain.exception.LivroNaoEncontradoException;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import com.example.biblioteca.infra.persistence.mapper.LivroEntityMapper;
import com.example.biblioteca.infra.persistence.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarLivroUseCase {
    private LivroRepository livroRepository;
    private LivroEntityMapper livroEntityMapper;

    public AtualizarLivroUseCase(LivroRepository livroRepository, LivroEntityMapper livroEntityMapper) {
        this.livroRepository = livroRepository;
        this.livroEntityMapper = livroEntityMapper;
    }

    public LivroEnitty atualizarLivro(Long livroId, LivroEnitty livroEnitty){
        Optional<LivroJpaEntity> byId = livroRepository.findById(livroId);
        if (byId.isPresent()) {
            byId.get().setAutor(livroEnitty.getAutor());
            byId.get().setTitulo(livroEnitty.getTitulo());
            byId.get().setPreco(livroEnitty.getPreco());
            byId.get().setGenero(livroEnitty.getGenero());
            byId.get().setDataPublicacao(livroEnitty.getDataPublicacao());
            return livroEntityMapper.toEntity(livroRepository.save(byId.get()));
        }
        throw new LivroNaoEncontradoException(livroId);
    }
}
