package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ImoveisCadastrados {
    private List <Imovel> imoveis = new ArrayList<>();

    public ImoveisCadastrados() {
    }

    public ImoveisCadastrados(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public void adicionarImovel (Imovel adicionarImovel){
        imoveis.add(adicionarImovel);
    }
    public void mostrarTodosOsImoveis(){
        for (Imovel referencia : imoveis){
            System.out.println(referencia.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder concatenador = new StringBuilder();
        concatenador.append("Lista de imóveis cadastrados:\n");
        concatenador.append("\n" + imoveis.toString());
        return concatenador.toString();
    }
}
