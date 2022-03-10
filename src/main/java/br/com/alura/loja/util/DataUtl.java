package br.com.alura.loja.util;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DataUtl {
    public static void cadastrarProdutos() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "descrição alternativa", new BigDecimal("800"), celulares );

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void cadastrarPedido() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "descrição alternativa", new BigDecimal("800"), celulares );

        Cliente cliente = new Cliente("Patricia", "1234568");

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDao.cadastrar(cliente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
