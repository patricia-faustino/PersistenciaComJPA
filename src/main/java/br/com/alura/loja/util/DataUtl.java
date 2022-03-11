package br.com.alura.loja.util;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.entity.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DataUtl {
    public static void cadastrarProdutos() {
        cadastrarPedido();
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

    public static void cadastrarPedido() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria eletronicos = new Categoria("ELETRONICOS");
        Categoria mesaBanho = new Categoria("MESA E BANHO");

        Produto celular = new Produto("Xiaomi Redmi", "descrição alternativa", new BigDecimal("800"), celulares);

        Produto ps5 = new Produto("PS5", "descrição alternativa", new BigDecimal("3000"), eletronicos);

        Produto monitor = new Produto("Monitor", "descrição alternativa", new BigDecimal("1300"), eletronicos);

        Produto almofadas = new Produto("Almofadas", "descrição alternativa", new BigDecimal("400"), eletronicos);

        Cliente cliente = new Cliente("Patricia", "1234568");

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(mesaBanho);
        categoriaDao.cadastrar(eletronicos);
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(almofadas);
        produtoDao.cadastrar(monitor);
        produtoDao.cadastrar(ps5);
        clienteDao.cadastrar(cliente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void popularDadosPerformance() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria eletronicos = new Categoria("ELETRONICOS");
        Categoria mesaBanho = new Categoria("MESA E BANHO");

        Produto celular = new Produto("Xiaomi Redmi", "descrição alternativa", new BigDecimal("800"), celulares);

        Produto ps5 = new Produto("PS5", "descrição alternativa", new BigDecimal("3000"), eletronicos);

        Produto monitor = new Produto("Monitor", "descrição alternativa", new BigDecimal("1300"), eletronicos);

        Produto almofadas = new Produto("Almofadas", "descrição alternativa", new BigDecimal("400"), eletronicos);

        Cliente cliente = new Cliente("Patricia", "1234568");

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);



        Pedido pedido = new Pedido(cliente);


        PedidoDao pedidoDao = new PedidoDao(entityManager);


        BigDecimal valorTotalVendido = pedidoDao.valorTotalVendido();

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(mesaBanho);
        categoriaDao.cadastrar(eletronicos);
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(almofadas);
        produtoDao.cadastrar(monitor);
        produtoDao.cadastrar(ps5);
        clienteDao.cadastrar(cliente);
        pedido.addItem(new ItemPedido(10, celular, pedido));
        pedido.addItem(new ItemPedido(40, ps5, pedido));
        pedido.addItem(new ItemPedido(70, monitor, pedido));
        pedido.addItem(new ItemPedido(20, almofadas, pedido));

        pedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
