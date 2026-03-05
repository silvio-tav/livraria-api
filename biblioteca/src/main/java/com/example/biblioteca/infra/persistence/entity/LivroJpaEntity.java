package com.example.biblioteca.infra.persistence.entity;

import com.example.biblioteca.domain.enums.GeneroLivro;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livros")
public class LivroJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;

    @Enumerated(EnumType.STRING)
    private GeneroLivro genero;

    private LocalDate dataPublicacao;
    private Double preco;
}
