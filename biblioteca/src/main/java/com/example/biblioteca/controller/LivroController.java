package com.example.biblioteca.controller;

import com.example.biblioteca.application.dto.LivroRequestDto;
import com.example.biblioteca.application.dto.LivroResponseDto;
import com.example.biblioteca.application.mapper.LivroDtoMapper;
import com.example.biblioteca.application.usecase.AtualizarLivroUseCase;
import com.example.biblioteca.application.usecase.CadastrarLivroUseCase;
import com.example.biblioteca.application.usecase.DeletarLivroUseCase;
import com.example.biblioteca.application.usecase.ListarLivrosUseCase;
import com.example.biblioteca.domain.entity.LivroEnitty;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final ListarLivrosUseCase listarLivrosUseCase;
    private final CadastrarLivroUseCase cadastrarLivroUseCase;
    private final AtualizarLivroUseCase atualizarLivroUseCase;
    private final DeletarLivroUseCase deletarLivroUseCase;
    private final LivroDtoMapper livroDtoMapper;

    public LivroController(ListarLivrosUseCase listarLivrosUseCase, CadastrarLivroUseCase cadastrarLivroUseCase, AtualizarLivroUseCase atualizarLivroUseCase, DeletarLivroUseCase deletarLivroUseCase, LivroDtoMapper livroDtoMapper) {
        this.listarLivrosUseCase = listarLivrosUseCase;
        this.cadastrarLivroUseCase = cadastrarLivroUseCase;
        this.atualizarLivroUseCase = atualizarLivroUseCase;
        this.deletarLivroUseCase = deletarLivroUseCase;
        this.livroDtoMapper = livroDtoMapper;
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDto>> ListarLivros(){
        List<LivroEnitty> livroEnitties = listarLivrosUseCase.listarLivros();
        List<LivroResponseDto> livroResponseDtoList = new ArrayList<>();
        for (int i = 0; i < livroEnitties.size(); i++) {
            livroResponseDtoList.add(livroDtoMapper.entityToResponse(livroEnitties.get(i)));
        }
        return ResponseEntity.ok(livroResponseDtoList);
    }

    @PostMapping
    public ResponseEntity<LivroResponseDto> cadastrarLivro(
            @RequestBody @Valid LivroRequestDto livroRequestDto
            ){
        LivroResponseDto livroResponseDto = livroDtoMapper.entityToResponse(
                        cadastrarLivroUseCase.cadastrarLivro(livroDtoMapper.requestToEntity(livroRequestDto))
                );
        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponseDto);
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(
            @PathVariable Long livroId,
            @RequestBody @Valid LivroRequestDto livroRequestDto
    ){
        return ResponseEntity.ok(
                livroDtoMapper.entityToResponse(
                        atualizarLivroUseCase.atualizarLivro(livroId, livroDtoMapper.requestToEntity(livroRequestDto))
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
