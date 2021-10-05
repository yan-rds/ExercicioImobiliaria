package br.com.zup;

public class Morador extends Pessoa{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Morador() {
    }

    public Morador(String nome) {
        super(nome);
    }

    public Morador(String nome, String cpf) {
        super(nome, cpf);
    }


}

