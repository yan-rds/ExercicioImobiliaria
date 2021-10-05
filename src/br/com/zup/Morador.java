package br.com.zup;

public class Morador extends Pessoa{
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Morador() {
    }

    public Morador(String nome) {
        super(nome);
    }

    public Morador(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

}

