package com.example.biblioteca.infra.exception;

import com.example.biblioteca.domain.exception.LivroNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Object> handleLivroNaoEncontrado(LivroNaoEncontradoException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "status",404,
                        "error", "Not Found",
                        "messege", ex.getMessage()
                ));
    }
}
