package com.baozistore.model;

import jakarta.persistence.*;

/**
 * Entidade que representa um Pedido da Baozi Store.
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "produto_id", nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Integer quantidade;

    // -------------------------------------------------------------------------
    // Construtores
    // -------------------------------------------------------------------------

    public Pedido() {}

    public Pedido(Long clientId, Long produtoId, Integer quantidade) {
        this.clientId = clientId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters
    // -------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", clientId=" + clientId + ", produtoId=" + produtoId + ", quantidade=" + quantidade + "}";
    }
}
