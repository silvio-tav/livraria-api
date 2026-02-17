package com.example.biblioteca.domain.exception;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(Long id) {
        super("Livro com ID " + id + " não foi encontrado.");
    }
}
