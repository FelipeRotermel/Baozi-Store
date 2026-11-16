package com.baozistore.service;

import com.baozistore.model.Produto;
import com.baozistore.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pela lógica de negócio de Produtos.
 */
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Salva um novo produto no banco de dados.
     *
     * @param produto objeto Produto a ser persistido
     * @return produto salvo com ID gerado
     */
    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Retorna a lista de todos os produtos cadastrados.
     *
     * @return lista de produtos
     */
    @Transactional(readOnly = true)
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id identificador do produto
     * @return Optional contendo o produto, ou vazio se não encontrado
     */
    @Transactional(readOnly = true)
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    /**
     * Remove um produto pelo seu ID.
     *
     * @param id identificador do produto a ser removido
     */
    @Transactional
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
