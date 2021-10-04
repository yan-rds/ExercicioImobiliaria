package br.com.zup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ImoveisCadastrados imobiliaria = new ImoveisCadastrados();

        boolean loopMorador = true;
        boolean loopMenu = true;

        while (loopMenu) {
            System.out.println("Sistema Imobiliário");
            System.out.println("Digite 1 para cadastrar um novo imóvel");
            System.out.println("Digite 2 para exibir todos os imóveis cadastrados");
            System.out.println("Digite 3 para remover um morador");
            System.out.println("Digite 4 para sair");
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
                    Funcionario novoFuncionario = new Funcionario(leitorFuncionario);
                    novoImovel.adicionarFuncionario(novoFuncionario);

                    while (loopMorador) {
                        System.out.println("Digite o nome dos moradores, ao terminar digite Sair");
                        String leitorMorador = leitor.nextLine();
                        if (leitorMorador.equalsIgnoreCase("Sair")) {
                            loopMorador = false;
                        } else {
                            System.out.println("Digite o cpf deste morador");
                            String leitorCpf = leitor.nextLine();
                            boolean cpfRepetido = false;
                            for (Morador referencia : novoImovel.getMoradores()){
                                if (leitorCpf.equalsIgnoreCase(referencia.getCpf())){
                                    System.out.println("CPF repetido, morador não cadastrado");
                                    cpfRepetido = true;
                                }
                            }
                            if (!cpfRepetido) {
                                Morador Novomorador = new Morador(leitorMorador, leitorCpf);
                                novoImovel.adicionarMorador(Novomorador);
                                System.out.println("morador adicionado " + Novomorador.getNome());
                            }
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
                    System.out.println("Qual é o endereço do imóvel?");
                    leitor.nextLine();
                    String enderecoImovel = leitor.nextLine();
                    System.out.println("Qual é o cpf do morador?");
                    String cpfRemover = leitor.nextLine();
                    Morador excluido = null;
                    for (Imovel referencia : imobiliaria.getImoveis()){
                        if (enderecoImovel.equalsIgnoreCase(referencia.getEndereco())){
                            for (Morador referenciaMorador : referencia.getMoradores()){
                                if (cpfRemover.equalsIgnoreCase(referenciaMorador.getCpf())){
                                    excluido = referenciaMorador;
                                }
                            }
                        }
                        referencia.getMoradores().remove(excluido);
                    }
                    break;
                case 4:
                    loopMenu = false;
            }
        }
    }
}
