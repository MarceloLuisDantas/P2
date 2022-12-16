package desafios;

/**
 * Classe que representa uma Acao relacionada a um Desafio
 */
public class Acao implements java.lang.Comparable<Acao> {
    private String data;       // Data de inicio 
    private int desafio_id;    // Id do Desafio relacionado
    private Integer progresso; // Progresso ?/100
    private int id;            // Id da acao

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
        if (total == -1) this.progresso += 10;
        else this.progresso += total;
        return concluido();
    }

    /**
     * @return Acao [id] [progresso]/100
     */
    public String toString() {
        return "Acao " + id + " " + progresso + "/100";
    } 

    public Integer getProgresso() { return this.progresso; } 
    public int getDesafioId() { return this.desafio_id; }
    public String getData() { return this.data; }
    public int getId() { return this.id; }

    public int compareTo(Acao a) {
        return this.progresso.compareTo(a.getProgresso());
    }
}
