package desafios;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por controlar os desafios
 */
public class ControlerDesafio {
    // Lista de desafios
    private List<Desafio> desafios = new ArrayList<Desafio>();

    /**
     * Cria um novo desafio
     * @param tokens Lista de Tokens contendo as informações necessarias
     * tokens[1] Titulo do desafio, 
     * tokens[2] Descrição do desafio, 
     */
    public void add_desafio(String[] tokens) {
        String titulo = tokens[1];
        String descri = tokens[2];
        desafios.add(new Desafio(titulo, descri));
    }

    /**
     * @param indice Indice do Desafio na lista
     * @return Represetanção em String de um desafio
     */
    public String exibi_desafio(int indice) {
        return desafios.get(indice).toString();
    }

    /**
     * Incrementa o contator de execução em 1
     * @param indice Indice do desafio na Lista
     */
    public void add_execucao(int indice) {
        desafios.get(indice).addExecucao();
    }

    /**
     * @param indice Indice do desafio a ser retornado
     * @return Desafio requisitado
     */
    public Desafio getDesafio(int indice) {
        return desafios.get(indice);
    }
}
