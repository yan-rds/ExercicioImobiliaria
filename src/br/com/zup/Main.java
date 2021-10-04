package br.com.zup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


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
                    Sistema.imobiliaria.adicionarImovel(Sistema.cadastrarImovel());
                    break;
                case 2:
                    System.out.println(Sistema.imobiliaria);
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
