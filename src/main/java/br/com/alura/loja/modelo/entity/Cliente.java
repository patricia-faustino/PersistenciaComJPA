package br.com.alura.loja.modelo.entity;

import br.com.alura.loja.modelo.DadosPessoais;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DadosPessoais dadosPessoais;

    public  Cliente() {}

    public Cliente(String name, String cpf) {
        this.dadosPessoais = new DadosPessoais(name, cpf);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.dadosPessoais.getName();
    }

    public String getCpf() {
        return this.dadosPessoais.getCpf();
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
}
