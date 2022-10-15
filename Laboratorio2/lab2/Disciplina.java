package lab2;

/**
* Representação de uma disciplica. Toda disciplica precisa possuir nome,
* 4 notas e a quantidade de horas percorridas pelo aluno.
* 
* @author Marcelo Dantas
*/
public class Disciplina {
    private Double[] notas = {0.0, 0.0, 0.0, 0.0};
    private String nome;
    private int horas;

    Disciplina(String nome) { this.nome = nome; }
    
    public void cadastraHoras(int horas) { this.horas += horas; }
    public void cadastraNota(int nota, double valorNota) { notas[nota - 1] = valorNota; }
    private Double media() {
        return (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
    }
    public boolean aprovado() { return media() >= 7; }
    
    /*
     * Formata os dados da disciplica e retorna uma String no formato
     * 
     * [nome] [horas] [media] [notas]
     */
    public String toString() {
        return String.format("%s %d %.1f [%.1f, %.1f, %.1f, %.1f]", 
            nome, horas, media(), notas[0], notas[1], notas[2], notas[3]);
    }
}
