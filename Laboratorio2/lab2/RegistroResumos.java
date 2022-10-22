package lab2;

import java.util.ArrayList;
import java.util.List;

/**
* Registro dos temas e resumos do aluno
* 
* @author Marcelo Dantas
*/
public class RegistroResumos {
    /* Limite maximo de resumos */
    private final int LIMITE; 

    /* Lista de resumos e lista de temas */
    private String[] resumos; 
    private String[] temas;   

    /* Cursos que indica qual indice escrever no 
     * array de resumos e temas */
    private int cursor; 

    /* Total de resumos já cadastrados */
    private int total;  

    RegistroResumos(int total) {
        this.resumos = new String[total];
        this.temas = new String[total];
        this.LIMITE = total;
    }

    /**
     * Metodo responsavel por retornar o total de resumos cadastrados
     * 
     * @return int - Total de resumos cadastrados
     */
    public int conta() { 
        return this.total; 
    }

    /**
     * Metodo responsavel por adicionar um tema e um resumo as listas
     * 
     * @param tema - Tema do resumo
     * @param resumo - Texto do resumo
     */
    public void adiciona(String tema, String resumo) {
        if (this.total != this.LIMITE) { 
            this.total += 1; 
        }
        
        this.temas[this.cursor] = tema;
        this.resumos[this.cursor] = resumo;

        /* Verifica se é preciso começar a sobrescrever os primeiros resumos */
        if (this.cursor != this.LIMITE - 1) 
            this.cursor += 1; 
        else 
            this.cursor = 0; 
    }

    /**
     * Metodo responsavel por retornar todos os resumos junto ao seu tema
     * 
     * @return String[] - Retorna strings formatadas com "[tema]: [resumo]""
     */    
    public String[] pegaResumos() {
        String[] lista = new String[this.total];
        for (int i = 0; i != this.total; i++)
            lista[i] = this.temas[i] + ": " + this.resumos[i];
        return lista;
    }

    /**
     * Metodo resposnavel por listar todos os resumos
     * 
     * @return String - String contendo todos os resumos já registrados
     */
    public String imprimeResumos() {
        String retorno = new String();
        retorno += String.format("- %d resumo(s) encontrado(s) \n- ", this.total);

        String[] suporte = new String[this.total];
        for (int i = 0; i != this.total; i++)
            suporte[i] = this.temas[i];

        return retorno + String.join(" | ", suporte);
    }

    /**
     * Metodo responsavel por ferificar se um resumo com um tema especifico já foi cadastrado
     * 
     * @param tema - Tema do resumo a ser verificado
     * @return Boolean - Resultado se existe um resumo com o tema especificado
     */
    public Boolean temResumo(String tema) {
        for (int i = 0; i != this.total; i++)
            if (this.temas[i].equals(tema)) 
                return true;
        return false;
    }

    /**
     * metodo responsavel por realizar a busca dos resumos de que 
     * possuam colisão com o trecho passado nos parametros
     * 
     * @param trecho - Trecho a ser busca entre os resumos
     * 
     * @return String[] - uma lista contendo os temas e resumos que foram encontrados pela colisão
     */
    public String[] busca(String trecho) {
        List<Integer> colisoes = new ArrayList<Integer>();
        for (int i = 0; i != this.LIMITE; i++) 
            if (this.resumos[i].contains(trecho)) 
                colisoes.add(i);
        
        String[] encontrados = new String[colisoes.size()];
        for (int i = 0; i != colisoes.size(); i++) 
            encontrados[i] = this.temas[i] + ": " + this.resumos[i];

        return encontrados;
    }
}
