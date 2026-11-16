package com.baozistore.controller;

import com.baozistore.model.Pedido;
import com.baozistore.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para o recurso Pedido.
 * Base URL: /pedidos
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * POST /pedidos
     * Cria um novo pedido.
     *
     * @param pedido dados do pedido recebidos no corpo da requisição (JSON)
     * @return pedido criado com status 201 Created
     */
    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        Pedido salvo = pedidoService.salvar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    /**
     * GET /pedidos
     * Retorna a lista completa de pedidos.
     *
     * @return lista de pedidos com status 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    /**
     * GET /pedidos/{id}
     * Busca um pedido pelo ID.
     *
     * @param id identificador do pedido
     * @return pedido encontrado ou 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /pedidos/{id}
     * Remove um pedido pelo ID.
     *
     * @param id identificador do pedido a ser removido
     * @return status 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
