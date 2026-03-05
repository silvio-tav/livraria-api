package com.example.biblioteca.infra.persistence.repository;

import com.example.biblioteca.domain.enums.GeneroLivro;
import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroJpaEntity, Long> {
    @Query("""
        SELECT l FROM LivroJpaEntity l
        WHERE (:titulo IS NULL OR LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
        AND (:autor IS NULL OR LOWER(l.autor) LIKE LOWER(CONCAT('%', :autor, '%')))
        AND (:genero IS NULL OR l.genero = :genero)
        AND (:precoMin IS NULL OR l.preco >= :precoMin)
        AND (:precoMax IS NULL OR l.preco <= :precoMax)
    """)
    List<LivroJpaEntity> listarComFiltros(
            String titulo,
            String autor,
            GeneroLivro genero,
            Double precoMin,
            Double precoMax
    );
}
