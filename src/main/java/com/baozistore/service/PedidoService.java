package com.baozistore.service;

import com.baozistore.model.Pedido;
import com.baozistore.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pela lógica de negócio de Pedidos.
 */
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    /**
     * Salva um novo pedido no banco de dados.
     *
     * @param pedido objeto Pedido a ser persistido
     * @return pedido salvo com ID gerado
     */
    @Transactional
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    /**
     * Retorna a lista de todos os pedidos cadastrados.
     *
     * @return lista de pedidos
     */
    @Transactional(readOnly = true)
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    /**
     * Busca um pedido pelo seu ID.
     *
     * @param id identificador do pedido
     * @return Optional contendo o pedido, ou vazio se não encontrado
     */
    @Transactional(readOnly = true)
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    /**
     * Remove um pedido pelo seu ID.
     *
     * @param id identificador do pedido a ser removido
     */
    @Transactional
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
