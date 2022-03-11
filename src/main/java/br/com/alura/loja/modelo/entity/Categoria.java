package br.com.alura.loja.modelo.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    private CategoriaId id;

    public Categoria(){}

    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "xpto");
    }

    public String getName() {
        return id.getName();
    }

}
