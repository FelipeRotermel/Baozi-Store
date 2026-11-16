package com.baozistore.controller;

import com.baozistore.model.Cliente;
import com.baozistore.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para o recurso Cliente.
 * Base URL: /clientes
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * POST /clientes
     * Cria um novo cliente.
     *
     * @param cliente dados do cliente recebidos no corpo da requisição (JSON)
     * @return cliente criado com status 201 Created
     */
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente salvo = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    /**
     * GET /clientes
     * Retorna a lista completa de clientes.
     *
     * @return lista de clientes com status 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    /**
     * GET /clientes/{id}
     * Busca um cliente pelo ID.
     *
     * @param id identificador do cliente
     * @return cliente encontrado ou 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /clientes/{id}
     * Remove um cliente pelo ID.
     *
     * @param id identificador do cliente a ser removido
     * @return status 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
