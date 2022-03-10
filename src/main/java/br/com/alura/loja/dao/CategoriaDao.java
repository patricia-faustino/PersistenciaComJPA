package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }

    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    public List<Categoria> buscarTodos() {
        String jpql = "SELECT p FROM Categoria p";
        return em.createQuery(jpql, Categoria.class).getResultList();
    }
}
