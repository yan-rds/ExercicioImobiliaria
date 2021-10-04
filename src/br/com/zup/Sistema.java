package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    static List<Morador> listaDeMoradores = new ArrayList<>();
    static ImoveisCadastrados imobiliaria = new ImoveisCadastrados();

    private static Scanner capturador (String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static int MenuInicial() {
        System.out.println("Sistema Imobiliário");
        System.out.println("Digite 1 para cadastrar um novo imóvel");
        System.out.println("Digite 2 para exibir todos os imóveis cadastrados");
        System.out.println("Digite 3 para remover um morador");
        int escolha = capturador("Digite 4 para sair").nextInt();

        return escolha;
    }


    public static Funcionario instanciarFuncionario(){
        String leitorFuncionario = capturador("Qual é o nome do funcionário responsável?").nextLine();
        Funcionario novoFuncionario = new Funcionario(leitorFuncionario);
        return novoFuncionario;
    }

    public static Morador instanciarMorador(){
        String leitorMorador = capturador("Digite o nome do morador").nextLine();
        String leitorCpf = capturador("Digite o CPF deste morador").nextLine();
        Morador novoMorador = new Morador();
        boolean cpfRepetido = false;
        for (Morador referencia : listaDeMoradores){
            if (leitorCpf.equalsIgnoreCase(referencia.getCpf())){
                System.out.println("CPF repetido, morador não cadastrado");
                cpfRepetido = true;
            }
        }
        if (!cpfRepetido) {
            novoMorador.setNome(leitorMorador);
            novoMorador.setCpf(leitorCpf);
        }
        return novoMorador;
    }

    public static List<Morador> atualizarListaDeMoradores(){
        boolean loopListaMorador = true;
        while (loopListaMorador){
            loopListaMorador = false;
            listaDeMoradores.add(instanciarMorador());
            String repetirCadastroMorador = capturador("Digite 'cadastro' para cadastrar um novo morador, do contrário, digite 'sair'").nextLine();
            if (repetirCadastroMorador.equalsIgnoreCase("cadastro")){
                loopListaMorador = true;
            }
        }
        return listaDeMoradores;
    }

    public static double aluguel(){
        double leitorAluguel = capturador("Qual é o valor do aluguel?").nextDouble();
        return leitorAluguel;
    }

    public static String endereco(){
        String leitorEndereco = capturador("Em qual endereço esse imóvel se localiza?").nextLine();
        return leitorEndereco;
    }

    public static Imovel cadastrarImovel(){
        Imovel novoImovel = new Imovel();
        List<Morador> resetarLista = new ArrayList<>();
        listaDeMoradores = resetarLista;
        novoImovel.definirEndereco(endereco());
        novoImovel.adicionarFuncionario(instanciarFuncionario());
        novoImovel.setMoradores(atualizarListaDeMoradores());
        novoImovel.definirValorAluguel(aluguel());
        return novoImovel;
    }

    public static void removerMorador(){
        String enderecoImovel = capturador("Qual é o endereço do imóvel").nextLine();
        System.out.println();
        String cpfRemovido = capturador("Qual é o CPF do morador a ser removido").nextLine();
        System.out.println();
        Morador excluido = null;
        for (Imovel referencia : imobiliaria.getImoveis()){
            if (enderecoImovel.equalsIgnoreCase(referencia.getEndereco())){
                for (Morador referenciaMorador : referencia.getMoradores()){
                    if (cpfRemovido.equalsIgnoreCase(referenciaMorador.getCpf())){
                        excluido = referenciaMorador;
                    }
                }
            }
            referencia.getMoradores().remove(excluido);
            System.out.println("Morador " + excluido + " removido.");
        }
    }


    public static void executarSistema() {
        boolean loopMenu = true;

        while (loopMenu) {
            switch (MenuInicial()) {
                case 1:
                    imobiliaria.adicionarImovel(cadastrarImovel());
                    break;
                case 2:
                    System.out.println(imobiliaria);
                    break;
                case 3:
                    removerMorador();
                    break;
                case 4:
                    loopMenu = false;
            }
        }
    }

}


