package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private String endereco;
    private double valorAluguel;
    private List <Morador> listaDeMoradores = new ArrayList<>();
    private Funcionario funcionarioResponsavel;

    public Imovel() {
    }

    public List<Morador> getListaDeMoradores() {
        return listaDeMoradores;
    }

    public void setListaDeMoradores(List<Morador> listaDeMoradores) {
        this.listaDeMoradores = listaDeMoradores;
    }

    public Imovel(String endereco, double valorAluguel) {
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public List<Morador> getMoradores() {
        return listaDeMoradores;
    }

    public void setMoradores(List<Morador> moradores) {
        this.listaDeMoradores = moradores;
    }

    public void adicionarMorador (Morador novoMorador){
        listaDeMoradores.add(novoMorador);
    }

    public void adicionarFuncionario (Funcionario funcionarioAdicionado){
        funcionarioResponsavel = funcionarioAdicionado;
    }

    public void definirValorAluguel (double aluguel){
        valorAluguel = aluguel;
    }

    public void definirEndereco (String enderecoEscolhido){
        endereco = enderecoEscolhido;
    }
    public void mostrarMoradores (){
        for (Morador referencia : listaDeMoradores){
            System.out.println(referencia.getNome());
        }
    }

    @Override
    public String toString() {
        StringBuilder concatenador = new StringBuilder();
        concatenador.append("\tA respeito do imóvel localizado no endereço " + endereco);
        concatenador.append(", suas informações são:\n");
        concatenador.append("Funcionário da imobiliária responsável: " + funcionarioResponsavel.getNome());
        concatenador.append("\nValor do aluguel: R$ "+ valorAluguel);
        concatenador.append("\nResidentes atuais:" + getMoradores().toString());
        concatenador.append("\n");
        return concatenador.toString();

    }

    /*
    Método antigo
    public void mostrarDados (){
        System.out.println("A respeito do imóvel localizado no endereço " + endereco + ", suas informações são:");
        System.out.println("Funcionário da imobiliária responsável: " + funcionarioResponsavel.getNome());
        System.out.println("Valor do aluguel: "+ valorAluguel);
        System.out.println("Residentes atuais:");
        mostrarMoradores();
    }*/

}
