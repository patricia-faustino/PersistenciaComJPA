package br.com.alura.loja.modelo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Informatica extends Produto{

    private String brand;

    private Integer model;

    public Informatica(String brand, Integer model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}
