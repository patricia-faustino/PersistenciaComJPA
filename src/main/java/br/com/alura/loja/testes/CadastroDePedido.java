package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.entity.Cliente;
import br.com.alura.loja.modelo.entity.ItemPedido;
import br.com.alura.loja.modelo.entity.Pedido;
import br.com.alura.loja.modelo.entity.Produto;
import br.com.alura.loja.modelo.vo.RelatorioDeVendas;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.util.DataUtl;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        DataUtl.cadastrarProdutos();

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        Produto celular = produtoDao.buscarPorId(1l);
        Produto ps5 = produtoDao.buscarPorId(2l);
        Produto monitor = produtoDao.buscarPorId(3l);
        Produto almofadas = produtoDao.buscarPorId(4l);

        Cliente cliente = clienteDao.buscarPorId(1l);

        entityManager.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.addItem(new ItemPedido(10, celular, pedido));
        pedido.addItem(new ItemPedido(40, ps5, pedido));
        pedido.addItem(new ItemPedido(70, monitor, pedido));
        pedido.addItem(new ItemPedido(20, almofadas, pedido));

        PedidoDao pedidoDao = new PedidoDao(entityManager);
        pedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();

        BigDecimal valorTotalVendido = pedidoDao.valorTotalVendido();
        System.out.println(valorTotalVendido);

        List<RelatorioDeVendas> relatorioVendas = pedidoDao.relatorioDeVendas();
        relatorioVendas.forEach(System.out::println);
        entityManager.close();
    }


}
