package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Sistema {

     private static List<Morador> listaDeMorador = new ArrayList<>();

     private static Scanner capturarDados (String mensagem){
          System.out.println(mensagem);
          return new Scanner(System.in);
     }

     public static int menuInicial(){
          System.out.println("Sistema Imobiliário");
          System.out.println("Digite 1 para cadastrar um novo imóvel");
          System.out.println("Digite 2 para exibir todos os imóveis cadastrados");
          int ultimaOpcao = capturarDados("Digite 3 para remover um morador").nextInt();
          return ultimaOpcao;
     }

     public static String pegarEndereco(){
          String endereco = capturarDados("Qual é o endereço do imóvel?").nextLine();
          return endereco;
     }

     public static Morador instaciarMorador(){
          Morador moradorInstanciado = new Morador();
          String nomeDoMorador = capturarDados("Qual é o nome deste morador?").nextLine();
          String cpfDoMorador = capturarDados("Qual é o CPF deste morador?").nextLine();
          moradorInstanciado.setCpf(cpfDoMorador);
          moradorInstanciado.setNome(nomeDoMorador);
          return moradorInstanciado;
     }

     public static List<Morador> atualizarListaDeMoradores (){

          listaDeMorador.add(instaciarMorador());


     }




}
