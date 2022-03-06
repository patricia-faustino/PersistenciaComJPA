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

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(celulares);
        celulares.setName("XPTO");
        entityManager.flush();
        entityManager.clear();
        celulares = entityManager.merge(celulares);
        celulares.setName("123");
        entityManager.flush();
        entityManager.remove(celulares);
        entityManager.flush();
    }
}
