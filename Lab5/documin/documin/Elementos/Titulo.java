package documin.Elementos;

public class Titulo extends Elemento {
    private int nivel;
    private boolean linkavel;

    public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
        super(valor, prioridade);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    @Override
    public String representacaoCompleta() {
        String result = "";
        result += nivel + ". " + this.getValor();
        if (linkavel) {
            result += " --\n1-" + this.getValor().toUpperCase();
        }
        return result; 
    }

    @Override
    public String representacaoResumida() {
        return nivel + ". " + this.getValor();
    }
}
