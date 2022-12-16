package desafios;

public class Desafio {
    private String titulo;
    private String descricao;
    private int execucao;

    public Desafio(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() { return this.titulo; }

    public String toString() {
        String result = "Titulo: " + titulo + "\n";
        result += execucao + " execuções";
        return result;
    }

    public void addExecucao() {
        this.execucao += 1;
    }
}
