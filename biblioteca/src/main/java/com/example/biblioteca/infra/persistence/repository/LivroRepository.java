package com.example.biblioteca.infra.persistence.repository;

import com.example.biblioteca.infra.persistence.entity.LivroJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroJpaEntity, Long> {

}
