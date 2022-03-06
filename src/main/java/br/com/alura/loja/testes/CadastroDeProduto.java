package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        Categoria celulares = new Categoria("celulares");
        Produto celular = new Produto("Xiaomi Redmi", "Melhor geração disponível", new BigDecimal("800"), celulares);

        EntityManager entityManager = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        entityManager.getTransaction().begin();
        entityManager.persist(celular);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
