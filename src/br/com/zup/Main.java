package br.com.zup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Funcionario funcionario = new Funcionario("");
        ImoveisCadastrados imobiliaria = new ImoveisCadastrados();

        boolean loopMorador = true;
        boolean loopMenu = true;

        while (loopMenu) {
            System.out.println("Sistema Imobiliário");
            System.out.println("Digite 1 para cadastrar um novo imóvel");
            System.out.println("Digite 2 para exibir todos os imóveis cadastrados");
            System.out.println("Digite 3 para encerrar");
            int escolhaMenu = leitor.nextInt();
            switch (escolhaMenu) {
                case 1:
                    // Cadastrar imóvel
                    Imovel novoImovel = new Imovel();
                    System.out.println("Qual é o endereço do imóvel?");
                    leitor.nextLine();
                    String leitorEndereco = leitor.nextLine();
                    novoImovel.definirEndereco(leitorEndereco);

                    System.out.println("Qual é o nome do funcionário responsável?");
                    String leitorFuncionario = leitor.nextLine();
                    funcionario.setNome(leitorFuncionario);
                    novoImovel.adicionarFuncionario(funcionario);

                    while (loopMorador) {
                        System.out.println("Digite o nome dos moradores, ao terminar digite Sair");
                        String leitorMorador = leitor.nextLine();
                        if (leitorMorador.equalsIgnoreCase("Sair")) {
                            loopMorador = false;
                        } else {
                            Morador Novomorador = new Morador(leitorMorador);
                            novoImovel.adicionarMorador(Novomorador);
                            System.out.println("morador adicionado " + Novomorador.getNome());
                        }
                    }
                    loopMorador = true;
                    System.out.println("Qual é o valor do aluguel?");
                    double leitorAluguel = leitor.nextDouble();
                    novoImovel.definirValorAluguel(leitorAluguel);
                    System.out.println("Imóvel cadastrado: ");
                    System.out.println(novoImovel);
                    imobiliaria.adicionarImovel(novoImovel);
                    break;
                case 2:
                    System.out.println(imobiliaria);
                    break;
                case 3:
                    System.out.println("Encerrando");
                    loopMenu = false;

            }
        }
    }
}
