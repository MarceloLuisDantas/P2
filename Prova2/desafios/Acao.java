package desafios;

/**
 * Classe que representa uma Acao relacionada a um Desafio
 */
public class Acao implements java.lang.Comparable<Acao> {
    private String data;       // Data de inicio 
    private int desafio_id;    // Id do Desafio relacionado
    private Integer progresso; // Progresso x/100
    private Integer id;            // Id da acao

    /**
     * Cria uma nova ação
     * 
     * @param desafio ID do desafio relacionado
     * @param data Data de inicio da ação
     * @param id Id da ação
     */
    public Acao(int desafio, String data, int id) {
        this.data = data;
        this.desafio_id = desafio;
        this.progresso = 0;
        this.id = id;
    }

    /**
     * Verificar se o progresso chegou em 100
     * @return Se a ação esta completa
     */
    private boolean concluido() {
        return this.progresso >= 100;
    }

    /**
     * Incrementa o progresso 
     * @param total Total a ser incrementado ao progresso
     * @return Se a ação foi concluida
     */
    public boolean add_progresso(int total) {
        if (total <= 0) 
            this.progresso += 10;
        else if (this.progresso + total >= 100) 
            this.progresso = 100;
        else 
            this.progresso += total; 
        return concluido();
    }

    /**
     * @return Acao [id] [progresso]/100
     */
    public String toString() {
        return "Acao " + id + " " + progresso + "/100";
    } 

    public int getProgresso() { return this.progresso; } 
    public int getDesafioId() { return this.desafio_id; }
    public String getData() { return this.data; }
    public Integer getId() { return this.id; }

    public int compareTo(Acao a) {
        if (this.progresso == a.getProgresso()) 
            return this.id.compareTo(a.getId());
        if (this.progresso.compareTo(a.getProgresso()) > 0)
            return -1;
        return 1;
    }
}
