package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
    private String name;

    private String cpf;

    public DadosPessoais(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public DadosPessoais(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
