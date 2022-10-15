package lab2;

/**
* Registro das horas de descanso e semanas percoridas pelo aluno
* 
* @author Marcelo Dantas
*/
public class Descanso {
    private int hDescanso;
    private int semanas;

    public void defineHorasDescanso(int valor) { hDescanso = valor; }
    public void defineNumeroSemanas(int valor) { semanas = valor; }

    /*
     * Funções responsavel por verificar se a proporçõa entre semanas
     * e horas de descanso estão de acordo com o recomendado
     */
    public String getStatusGeral() {
        if ( hDescanso == 0 ) { return "cansado"; }
        return ((hDescanso / 26) >= semanas) ? "descansado" : "cansado";
    } 
}
