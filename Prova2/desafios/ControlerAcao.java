package desafios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Classe responsavel por gerenciar Ações
 */
public class ControlerAcao {
    // HashMap relacionando um ID a uma Ação
    private HashMap<Integer, Acao> acoes = new HashMap<Integer, Acao>();

    /**
     * Cria uma nova ação
     * @param tokens Lista de Tokens contendo as informações necessarias
     * tokens[1] Id do desafio, 
     * tokens[2] Data de inicio da Ação, 
     * tokens[3] Id da Ação
     */
    public void add_acao(String[] tokens) {
        int desafio_id = Integer.parseInt(tokens[1]);
        String data = tokens[2];
        int id = Integer.parseInt(tokens[3]);
        acoes.put(id, new Acao(desafio_id, data, id));
    }

    /**
     * Incrementa o progresso de uma ação
     * 
     * @param id Id da ação
     * @param total Total a ser incrementado
     * @return Se a açõa foi completada
     */
    public boolean add_progresso(int id, int total) {
        return acoes.get(id).add_progresso(total);
    }

    /**
     * @return Retorna uma lista com todas as ações ordenadas pelo progresso
     */
    public List<Acao> acoes_ordenadas() {
        List<Acao> lista = new ArrayList<Acao>(acoes.values());
        Collections.sort(lista);
        return lista;
    }

    /**
     * @param id Id da ação a ser exibido
     * @return Representação em String da ação
     */
    public String exibi_acao(int id) {
        return acoes.get(id).toString();
    }

    /**
     * @param id Id da ação a ser retornada
     * @return Ação requisitada
     */
    public Acao getAcao(int id) {
        return acoes.get(id);
    }
}
