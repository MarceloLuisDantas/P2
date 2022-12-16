package desafios;

/**
 * Classe que representa um desafio a ser concluido
 */
public class Desafio {
    private String titulo;    // Qual o objetivo
    private String descricao; // Descrição sobre o objetivo
    private int execucao;     // Quantas vezes foi executado

    /**
     * Cria um novo desafio.
     * 
     * @param titulo Qual o objeitvo do desafio
     * @param descricao Descrição sobre o objetivo
     */
    public Desafio(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() { return this.titulo; }

    /**
     * @return Titulo: [titulo] [execucao] Execuções
     */
    public String toString() {
        String result = "Titulo: " + titulo + "\n";
        result += execucao + " Execuções";
        return result;
    }

    /**
     * Incrimenta o contador de execuções
     */
    public void addExecucao() {
        this.execucao += 1;
    }
}
