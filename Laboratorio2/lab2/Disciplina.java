package lab2;

import java.util.Arrays;

/**
* Representação de uma disciplica. Toda disciplica precisa possuir nome,
* 4 notas e a quantidade de horas percorridas pelo aluno.
* 
* @author Marcelo Dantas
*/
public class Disciplina {
    /* lista de notas */
    private double[] notas;
    /* lista de pesos de cada nota */
    private int[] pesos;
    /* nome da disciplina */
    private String nome;
    /* horas totais dedicadas a disciplina */
    private int horas;

    Disciplina(String nome) { 
        this.nome = nome; 
        this.notas = new double[4];
        this.pesos = new int[]{1, 1, 1, 1};
    }

    Disciplina(String nome, int totalNotas) { 
        this.nome = nome; 
        this.notas = new double[totalNotas];
        this.pesos = new int[totalNotas];
        for (int i = 0; i != totalNotas; i++) 
            this.pesos[i] = 1;
    }
    
    Disciplina(String nome, int totalNotas, int[] pesos) { 
        this.nome = nome; 
        this.notas = new double[totalNotas];
        this.pesos = pesos;
    }

    /**
     * Metodo responsavel por adicionar horas ao total de horas
     * 
     * @param horas - horas
     */
    public void cadastraHoras(int horas) { this.horas += horas; }
    /**
     * Metodo responsavel por cadastrar as notas do aluno
     * 
     * @param nota - indice da nota na lista de notas
     * @param valorNota - valor da nota do indice especificado
     */
    public void cadastraNota(int nota, double valorNota) { 
        this.notas[nota - 1] = valorNota; 
    }

    /**
     * Metodo responsavel por calcular a media total
     * 
     * @return Double - media
     */
    private double media() {
        double media = 0;
        for (int i = 0; i != this.notas.length; i++) 
            media += (this.notas[i] * this.pesos[i]);
        
        int peso = 0;
        for (int p : this.pesos) 
            peso += p;

        return media / peso;
    }
    /**
     * Metodo responsavel por verificar se o aluno esta aprovado
     *  
     * @return boolean - Resultado se ele esta aprovado
     */
    public boolean aprovado() { 
        return media() >= 7; 
    }
    
    /**
     * Formata os dados da disciplica e retorna uma String no formato
     * 
     * @return String - String com o nome horas medias e notas no formato - [nome] [horas] [media] [notas]
     */
    public String toString() {
        return String.format("%s %d %.1f [%.1f, %.1f, %.1f, %.1f]", 
        this.nome, this.horas, media(), this.notas[0], this.notas[1], this.notas[2], this.notas[3]);
    }
}
