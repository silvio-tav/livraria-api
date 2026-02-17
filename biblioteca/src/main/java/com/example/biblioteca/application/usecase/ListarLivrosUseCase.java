package com.example.biblioteca.application.usecase;

import com.example.biblioteca.domain.entity.LivroEnitty;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import com.example.biblioteca.infra.persistence.mapper.LivroEntityMapper;
import com.example.biblioteca.infra.persistence.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarLivrosUseCase {
    private LivroRepository repository;
    private LivroEntityMapper livroEntityMapper;

    public ListarLivrosUseCase(LivroRepository repository, LivroEntityMapper livroEntityMapper) {
        this.repository = repository;
        this.livroEntityMapper = livroEntityMapper;
    }

    public List<LivroEnitty> listarLivros(){
        List<LivroJpaEntity> all = repository.findAll();
        List<LivroEnitty> livroEnitties = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            livroEnitties.add(livroEntityMapper.toEntity(all.get(i)));
        }
        return livroEnitties;
    }
}
