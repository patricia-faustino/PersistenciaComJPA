package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.util.DataUtl;

import javax.persistence.EntityManager;

public class CadastroDePedido {
    public static void main(String[] args) {
        DataUtl.cadastrarProdutos();

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        Produto produto = produtoDao.buscarPorId(1l);
        Cliente cliente = clienteDao.buscarPorId(1l);

        entityManager.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.addItem(new ItemPedido(10, produto, pedido));

        PedidoDao pedidoDao = new PedidoDao(entityManager);
        pedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
