package desafios;

public class Acao implements java.lang.Comparable<Acao> {
    private String data; 
    private int desafio_id;   
    private Integer progresso;
    private int id;

    public Acao(int desafio, String data, int id) {
        this.data = data;
        this.desafio_id = desafio;
        this.progresso = 0;
        this.id = id;
    }

    private boolean concluido() {
        return this.progresso >= 100;
    }

    public boolean add_progresso(int total) {
        if (total == -1) this.progresso += 10;
        else this.progresso += total;
        return concluido();
    }

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
