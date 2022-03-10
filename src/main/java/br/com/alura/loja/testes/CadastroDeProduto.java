package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.util.DataUtl;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        DataUtl.cadastrarProdutos();

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        Produto produto = produtoDao.buscarPorId(1l);
        System.out.println(produto.getPrice());

        produtoDao.buscarTodos().forEach(prdt -> System.out.println(prdt.getPrice()));

        produtoDao.buscarProdutosPorNome("Xiaomi Redmi").forEach(prdt -> System.out.println(prdt.getPrice()));

        produtoDao.buscarProdutosPorCategoria("CELULARES").forEach(prdt -> System.out.println(prdt.getPrice()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutosPorNome("Xiaomi Redmi");
        System.out.println(precoDoProduto);
    }


}
