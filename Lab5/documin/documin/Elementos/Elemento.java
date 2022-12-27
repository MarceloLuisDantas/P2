package documin.Elementos;

import java.util.HashMap;
import java.util.Map;

public class Elemento {
    private Map<String, String> propriedades = new HashMap<String, String>();
    private int prioridade;
    private String valor;
    
    public Elemento(String valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

    public String getValor() { return this.valor; }

    public String representacaoCompleta() {
        return this.valor;
    }

    public String representacaoResumida() {
        return this.valor;
    }
}
