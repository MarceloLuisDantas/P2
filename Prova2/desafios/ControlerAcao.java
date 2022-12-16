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
    // Lista de ações completas
    private List<Integer> acoes_completas = new ArrayList<Integer>();

    /**
     * Cria uma nova ação
     * @param tokens Lista de Tokens contendo as informações necessarias
     * tokens[1] Id do desafio, 
     * tokens[2] Data de inicio da Ação, 
     * tokens[3] Id da Ação
     */
    public boolean add_acao(String[] tokens) {
        int id = Integer.parseInt(tokens[3]);
        if (!acoes.containsKey(id)) {
            int desafio_id = Integer.parseInt(tokens[1]);
            String data = tokens[2];
            acoes.put(id, new Acao(desafio_id, data, id));
            return true;
        } else {
            System.out.println("Não se pode adicionar 2 ações com om moes ID");
            return false;
        }
    }

    /**
     * Incrementa o progresso de uma ação
     * 
     * @param id Id da ação
     * @param total Total a ser incrementado
     * @return Se a açõa foi completada
     */
    public boolean add_progresso(int id, int total) {
        if (acoes.get(id).add_progresso(total)) {
            acoes_completas.add(id);
            return true;
        } 
        return false;
    }

    /**
     * Verfica se uma ação esta completa
     * @param id Id da ação
     * @return Se a ação já foi completada
     */
    public boolean acao_completa(int id) {
        return acoes_completas.contains(id);
    }

    /**
     * @return Retorna uma lista com todas as ações ordenadas pelo progresso
     */
    public List<Acao> acoes_ordenadas() {
        List<Acao> lista = new ArrayList<Acao>(acoes.values());
        Collections.sort(lista);
        return lista;
    }

    public boolean existeAcao(int id) {
        return acoes.containsKey(id);
    }

    /**
     * @param id Id da ação a ser exibido
     * @return Representação em String da ação
     */
    public String exibi_acao(int id) {
        if (existeAcao(id))
            return acoes.get(id).toString();
        return "ID não encontrado";
    }

    /**
     * @param id Id da ação a ser retornada
     * @return Ação requisitada
     */
    public Acao getAcao(int id) {
        return acoes.get(id);
    }
}
