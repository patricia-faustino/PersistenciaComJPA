package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.entity.Pedido;
import br.com.alura.loja.modelo.vo.RelatorioDeVendas;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager entityManager;

    public PedidoDao(EntityManager em) {
        this.entityManager = em;
    }

    public void cadastrar(Pedido pedido) {
        this.entityManager.persist(pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.totalValue) FROM Pedido p";
        return entityManager.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<RelatorioDeVendas> relatorioDeVendas() {
        String jpql = "SELECT new br.com.alura.loja.modelo.vo.RelatorioDeVendas(" +
                "produto.name" +
                ", SUM(item.quantity)" +
                ", MAX(pedido.date))" +
                " FROM Pedido pedido" +
                " JOIN pedido.itens item" +
                " JOIN item.produto produto" +
                " GROUP BY produto.name" +
                " ORDER BY item.quantity DESC";

        return entityManager.createQuery(jpql, RelatorioDeVendas.class)
                .getResultList();
    }

}