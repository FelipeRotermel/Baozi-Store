package com.baozistore.service;

import com.baozistore.model.Cliente;
import com.baozistore.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pela lógica de negócio de Clientes.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Salva um novo cliente no banco de dados.
     *
     * @param cliente objeto Cliente a ser persistido
     * @return cliente salvo com ID gerado
     */
    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Retorna a lista de todos os clientes cadastrados.
     *
     * @return lista de clientes
     */
    @Transactional(readOnly = true)
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente pelo seu ID.
     *
     * @param id identificador do cliente
     * @return Optional contendo o cliente, ou vazio se não encontrado
     */
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    /**
     * Remove um cliente pelo seu ID.
     *
     * @param id identificador do cliente a ser removido
     */
    @Transactional
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
