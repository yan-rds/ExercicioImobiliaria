package br.com.zup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);
        Funcionario funcionario = new Funcionario("");
        Imovel imovel = new Imovel("", 0);
        ImoveisCadastrados imobiliaria = new ImoveisCadastrados();

        boolean loopMorador = true;


        // Cadastrar imóvel
        System.out.println("Qual é o nome do funcionário responsável?");
        String leitorFuncionario = leitor.nextLine();
        funcionario.setNome(leitorFuncionario);
        imovel.adicionarFuncionario(funcionario);

        while (loopMorador) {
            System.out.println("Digite o nome dos moradores, ao terminar digite Sair");
            String leitorMorador = leitor.nextLine();
            if (leitorMorador.equalsIgnoreCase("Sair")) {
                loopMorador = false;
            } else {
                Morador Novomorador = new Morador(leitorMorador);
                imovel.adicionarMorador(Novomorador);
                System.out.println("morador adicionado " + Novomorador.getNome());
            }
        }

        System.out.println("Qual é o valor do aluguel?");
        double leitorAluguel = leitor.nextDouble();
        imovel.definirValorAluguel(leitorAluguel);
        imovel.mostrarDados();


    }
}
