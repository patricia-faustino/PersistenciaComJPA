package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id) {
      return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarProdutosPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.name = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Produto> buscarProdutosPorCategoria(String nomeCategoria) {
        String jpql = "SELECT p FROM Produto p, Categoria c WHERE c = p.categoria AND c.name = :nomeCategoria";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nomeCategoria", nomeCategoria)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutosPorNome(String nome) {
        String jpql = "SELECT p.price FROM Produto p WHERE p.name = ?1";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }
}