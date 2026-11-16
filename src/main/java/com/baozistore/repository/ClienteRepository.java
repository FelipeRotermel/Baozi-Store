package com.baozistore.repository;

import com.baozistore.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade Cliente.
 * Herda operações CRUD e paginação do JpaRepository.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
