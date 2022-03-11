package br.com.alura.loja.modelo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "preco_unitario")
    private BigDecimal unitPrice;

    @Column(name = "quantidade")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public ItemPedido() {}

    public ItemPedido(Integer quantity, Produto produto, Pedido pedido) {
        this.quantity = quantity;
        this.produto = produto;
        this.pedido = pedido;
        this.unitPrice = produto.getPrice();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getValor() {
        return unitPrice.multiply(new BigDecimal(quantity));
    }
}
