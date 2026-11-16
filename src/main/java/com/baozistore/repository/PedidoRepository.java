package com.baozistore.repository;

import com.baozistore.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade Pedido.
 * Herda operações CRUD e paginação do JpaRepository.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
