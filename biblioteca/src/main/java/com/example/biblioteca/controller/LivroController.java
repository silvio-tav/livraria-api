package com.example.biblioteca.controller;

import com.example.biblioteca.application.dto.LivroFiltroDto;
import com.example.biblioteca.application.dto.LivroRequestDto;
import com.example.biblioteca.application.dto.LivroResponseDto;
import com.example.biblioteca.application.mapper.LivroMapper;
import com.example.biblioteca.application.usecase.AtualizarLivroUseCase;
import com.example.biblioteca.application.usecase.CadastrarLivroUseCase;
import com.example.biblioteca.application.usecase.DeletarLivroUseCase;
import com.example.biblioteca.application.usecase.ListarLivrosUseCase;
import com.example.biblioteca.domain.entity.LivroEnitty;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final ListarLivrosUseCase listarLivrosUseCase;
    private final CadastrarLivroUseCase cadastrarLivroUseCase;
    private final AtualizarLivroUseCase atualizarLivroUseCase;
    private final DeletarLivroUseCase deletarLivroUseCase;
    private final LivroMapper livroMapper;

    public LivroController(ListarLivrosUseCase listarLivrosUseCase, CadastrarLivroUseCase cadastrarLivroUseCase, AtualizarLivroUseCase atualizarLivroUseCase, DeletarLivroUseCase deletarLivroUseCase, LivroMapper livroMapper) {
        this.listarLivrosUseCase = listarLivrosUseCase;
        this.cadastrarLivroUseCase = cadastrarLivroUseCase;
        this.atualizarLivroUseCase = atualizarLivroUseCase;
        this.deletarLivroUseCase = deletarLivroUseCase;
        this.livroMapper = livroMapper;
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDto>> listarLivrosFlitros(
            @ModelAttribute LivroFiltroDto filtroDTO
            ){
        List<LivroEnitty> livroEnitties = listarLivrosUseCase.listarLivrosComFiltros(filtroDTO);
        return ResponseEntity.ok(livroEnitties.stream().map(livroMapper::entityToResponse).toList());
    }

    @PostMapping
    public ResponseEntity<LivroResponseDto> cadastrarLivro(
            @RequestBody @Valid LivroRequestDto livroRequestDto
            ){
        LivroResponseDto livroResponseDto = livroMapper.entityToResponse(
                        cadastrarLivroUseCase.cadastrarLivro(livroMapper.requestToEntity(livroRequestDto), livroRequestDto.getLivrariaId())
                );
        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponseDto);
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(
            @PathVariable Long livroId,
            @RequestBody @Valid LivroRequestDto livroRequestDto
    ){
        return ResponseEntity.ok(
                livroMapper.entityToResponse(
                        atualizarLivroUseCase.atualizarLivro(livroId, livroMapper.requestToEntity(livroRequestDto))
                )
        );
    }

    @DeleteMapping("/{livroId}")
    public ResponseEntity<Void> deletarLivro(
            @PathVariable Long livroId
    ){
        deletarLivroUseCase.deletarLivro(livroId);
        return ResponseEntity.noContent().build();
    }
}
