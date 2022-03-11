package br.com.alura.loja.testes;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.entity.Pedido;
import br.com.alura.loja.modelo.entity.Produto;
import br.com.alura.loja.util.DataUtl;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PerformanceConsultas {

    public static void main(String[] args) {
        DataUtl.popularDadosPerformance();
        EntityManager em = JPAUtil.getEntityManager();

        PedidoDao pedidoDao = new PedidoDao(em);

        Pedido pedido = pedidoDao.buscarPedidoComCliente(1L);

        List<Produto> produtos = pedidoDao.buscarPedidoPorParametrosComCriteria("PS5", null, null);

        produtos.forEach(System.out::println);
        em.close();
        System.out.println(pedido.getCliente().getName());
    }
}
