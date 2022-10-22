package lab2;

/**
 * Registro das horas de descanso e semanas percoridas pelo aluno
 * 
 * @author Marcelo Dantas
 */
public class Descanso {
    /* total de horas descansadas durante as semanas */
    private int horasDescanso;

    /* total de semanas percorridas */
    private int semanas;

    /* comentario sobre o estado do aluno */
    private String comentario = "";

    /** 
     * Metodo para definir o total de horas descansadas 
     * 
     * @param valor - Valor total de horas
     */
    public void defineHorasDescanso(int valor) { 
        this.horasDescanso = valor; 
    }

    /** 
     * Metodo que define o total de numeros 
     * 
     * @param valor - Valor total de semanas
     */
    public void defineNumeroSemanas(int valor) { 
        this.semanas = valor; 
    }


    /**
     * Metodo responsavel por definir um emoji como comentario
     * 
     * @param emoji - Emoji a ser colocado no comentario
     */
    public void defineComentario(String emoji) {
        this.comentario = emoji;
    }

    /** 
     * Funções responsavel por verificar se a proporçõa entre semanas
     * e horas de descanso estão de acordo com o recomendado
     * 
     * @return String - Dis se o aluno esta descansado junto ao comentario
     */
    public String getStatusGeral() {
        String resultado = "cansado";
        if ((horasDescanso / 26) >= semanas)  
            resultado = "descansado"; 
        
        if (!this.comentario.equals("")) 
            resultado += " - " + this.comentario;
        
        return resultado;
    } 
}
