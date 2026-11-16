package com.baozistore.repository;

import com.baozistore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade Produto.
 * Herda operações CRUD e paginação do JpaRepository.
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
