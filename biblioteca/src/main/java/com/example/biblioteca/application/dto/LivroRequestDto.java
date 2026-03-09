package com.example.biblioteca.application.dto;

import com.example.biblioteca.domain.enums.GeneroLivro;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LivroRequestDto {
    @NotBlank
    @Size(min = 1, max = 30)
    @JsonProperty
    private String titulo;

    @NotBlank
    @Size(min = 1, max = 30)
    @JsonProperty
    private String autor;

    @NotNull
    @JsonProperty
    private GeneroLivro genero;

    @NotNull
    @JsonProperty
    private LocalDate dataPublicacao;

    @NotNull
    @DecimalMin(value = "0.1", message = "O preço deve ser maior que 0")
    @JsonProperty
    private Double preco;

    @NotNull
    @JsonProperty
    private Long LivrariaId;
}
