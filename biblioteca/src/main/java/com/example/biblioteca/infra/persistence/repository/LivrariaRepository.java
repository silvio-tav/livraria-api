package com.example.biblioteca.infra.persistence.repository;

import com.example.biblioteca.infra.persistence.entity.LivrariaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrariaRepository extends JpaRepository<LivrariaJpaEntity, Long> {

}
