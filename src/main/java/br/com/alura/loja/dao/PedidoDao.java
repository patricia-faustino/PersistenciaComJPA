package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.entity.Pedido;
import br.com.alura.loja.modelo.entity.Produto;
import br.com.alura.loja.modelo.vo.RelatorioDeVendas;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public Pedido buscarPedidoComCliente(Long id) {
        return entityManager.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Produto> buscarPedidoPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);

        Predicate filtros = builder.and();

        if (nome != null && !nome.trim().isEmpty()) {
            filtros = builder.and(filtros, builder.equal(from.get("name"), nome));
        }

        if(preco != null){
            filtros = builder.and(filtros, builder.equal(from.get("price"), preco));
        }

        if(dataCadastro != null){
            filtros =builder.and(filtros, builder.equal(from.get("registerDate"), dataCadastro));
        }

        query.where(filtros);

        return entityManager.createQuery(query).getResultList();

    }


}