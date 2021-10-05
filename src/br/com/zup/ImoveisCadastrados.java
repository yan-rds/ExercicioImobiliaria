package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ImoveisCadastrados {
    private List <Imovel> listaDeImoveis = new ArrayList<>();

    public ImoveisCadastrados() {
    }

    public ImoveisCadastrados(List<Imovel> listaDeImoveis) {
        this.listaDeImoveis = listaDeImoveis;
    }

    public List<Imovel> getListaDeImoveis() {
        return listaDeImoveis;
    }

    public void setListaDeImoveis(List<Imovel> listaDeImoveis) {
        this.listaDeImoveis = listaDeImoveis;
    }

    public void adicionarImovel (Imovel adicionarImovel){
        listaDeImoveis.add(adicionarImovel);
    }
    public void mostrarTodosOsImoveis(){
        for (Imovel referencia : listaDeImoveis){
            System.out.println(referencia.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder concatenador = new StringBuilder();
        concatenador.append("Lista de imóveis cadastrados:\n");
        concatenador.append("\n" + listaDeImoveis.toString());
        return concatenador.toString();
    }
}
