package desafios;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por controlar os desafios
 */
public class ControlerDesafio {
    // Lista de desafios
    private List<Desafio> desafios = new ArrayList<Desafio>();


    private boolean tituloCadastrado(String titulo) {
        for (Desafio d : desafios) 
            if (d.getTitulo().equals(titulo)) 
                return true;
        return false;
    }

    /**
     * Cria um novo desafio
     * 
     * @param tokens Lista de Tokens contendo as informações necessarias
     * tokens[1] Titulo do desafio, 
     * tokens[2] Descrição do desafio, 
     * @return Se já existe um desafio com mesmo nome
     */
    public boolean add_desafio(String[] tokens) {
        String titulo = tokens[1];
        if (tituloCadastrado(titulo))
            return false;
        String descri = tokens[2];
        desafios.add(new Desafio(titulo, descri));
        return true;
    }

    /**
     * Verifica a possição deu desafio na lista de desafios
     * 
     * @param titulo Titulo do desafio
     * @return Possição do desafio na lista, caso não existe é retornado -1
     */
    public int get_poss(String titulo) {
        for (Desafio d : desafios) 
            if (d.getTitulo().equals(titulo))
                return desafios.indexOf(d);
        return -1;
    }

    /**
     * Verifica se um indice passado estra entre os disponiveis na lista de Desafios.
     * @param indice Indice desejado
     * @return Se o indice este entre os indices disponiveis
     */
    public boolean existeDesafio(int indice) {
        return desafios.size() >= indice;
    }

    /**
     * @param indice Indice do Desafio na lista
     * @return Represetanção em String de um desafio
     */
    public String exibi_desafio(int indice) {
        if (existeDesafio(indice))
            return desafios.get(indice).toString();
        return "Indice recebido não existente";
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
