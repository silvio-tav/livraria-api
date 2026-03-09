package com.example.biblioteca.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livraria")
public class LivrariaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long livrariaId;
    private String nomeLivraria;
    private String rua;
    private String numero;
    private String cep;
    @OneToMany(mappedBy = "livraria")
    private List<LivroJpaEntity> livros;
}
