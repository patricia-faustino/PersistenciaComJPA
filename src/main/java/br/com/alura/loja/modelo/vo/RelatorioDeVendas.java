package br.com.alura.loja.modelo;

import java.time.LocalDate;

public class RelatorioDeVendas {

    private String productName;

    private Long soldAmount;

    private LocalDate lastSaleDate;

    public RelatorioDeVendas(String productName, Long soldAmount, LocalDate lastSaleDate) {
        this.productName = productName;
        this.soldAmount = soldAmount;
        this.lastSaleDate = lastSaleDate;
    }

    public String getProductName() {
        return productName;
    }

    public Long getSoldAmount() {
        return soldAmount;
    }

    public LocalDate getLastSaleDate() {
        return lastSaleDate;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendas{" +
                "productName='" + productName + '\'' +
                ", soldAmount=" + soldAmount +
                ", lastSaleDate=" + lastSaleDate +
                '}';
    }
}
