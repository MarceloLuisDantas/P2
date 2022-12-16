package desafios;

import java.util.ArrayList;
import java.util.List;

public class ControlerDesafio {
    private List<Desafio> desafios = new ArrayList<Desafio>();

    public void add_desafio(String[] tokens) {
        String titulo = tokens[1];
        String descri = tokens[2];
        desafios.add(new Desafio(titulo, descri));
    }

    public String exibi_desafio(int indice) {
        return desafios.get(indice).toString();
    }

    public void add_execucao(int indice) {
        desafios.get(indice).addExecucao();
    }

    public Desafio getDesafio(int indice) {
        return desafios.get(indice);
    }
}
