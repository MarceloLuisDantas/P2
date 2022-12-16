package desafios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ControlerAcao {
    private HashMap<Integer, Acao> acoes = new HashMap<Integer, Acao>();

    public void add_acao(String[] tokens) {
        int desafio_id = Integer.parseInt(tokens[1]);
        String data = tokens[2];
        int id = Integer.parseInt(tokens[3]);
        acoes.put(id, new Acao(desafio_id, data, id));
    }

    public boolean add_progresso(int id, int total) {
        return acoes.get(id).add_progresso(total);
    }

    public List<Acao> acoes_ordenadas() {
        List<Acao> lista = new ArrayList<Acao>(acoes.values());
        Collections.sort(lista);
        return lista;
    }

    public String exibi_acao(int id) {
        return acoes.get(id).toString();
    }

    public Acao getAcao(int id) {
        return acoes.get(id);
    }
}
