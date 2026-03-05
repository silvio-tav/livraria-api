package com.example.biblioteca.application.usecase;

import com.example.biblioteca.application.dto.LivroFiltroDTO;
import com.example.biblioteca.application.mapper.LivroDtoMapper;
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

    public List<LivroEnitty> listarLivrosComFiltros(LivroFiltroDTO filtroDTO){
        List<LivroJpaEntity> livroJpaEntities = repository.listarComFiltros(
                filtroDTO.getTitulo(),
                filtroDTO.getAutor(),
                filtroDTO.getGenero(),
                filtroDTO.getPrecoMin(),
                filtroDTO.getPrecoMax()
        );
        return livroJpaEntities.stream().map(livroEntityMapper::toEntity).toList();
    }
}
