package com.baozistore.controller;

import com.baozistore.model.Produto;
import com.baozistore.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para o recurso Produto.
 * Base URL: /produtos
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * POST /produtos
     * Cria um novo produto.
     *
     * @param produto dados do produto recebidos no corpo da requisição (JSON)
     * @return produto criado com status 201 Created
     */
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto salvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    /**
     * GET /produtos
     * Retorna a lista completa de produtos.
     *
     * @return lista de produtos com status 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    /**
     * GET /produtos/{id}
     * Busca um produto pelo ID.
     *
     * @param id identificador do produto
     * @return produto encontrado ou 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /produtos/{id}
     * Remove um produto pelo ID.
     *
     * @param id identificador do produto a ser removido
     * @return status 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
