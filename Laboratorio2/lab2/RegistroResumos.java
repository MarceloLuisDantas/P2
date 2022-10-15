package lab2;

/**
* Registro dos temas e resumos do aluno
* 
* @author Marcelo Dantas
*/
public class RegistroResumos {
    /* 
    * Limite maximo de resumos. Caso esse valor sejá atingido os valores
    * do começo da lista de resumos seram sobrescritos.
    */
    private final int LIMITE; 
    private String[] resumos; // Foi escolhido utilizar 2 listas ao invês de uma por
    private String[] temas;   // facilitar utilizar uma das 2 listas individualmente
    private int cursor; /* Indicador de qual indice das listas atualizar */
    private int total;  /* Total de resumos já registrados */

    RegistroResumos(int total) {
        resumos = new String[total];
        temas = new String[total];
        LIMITE = total;
    }

    public int conta() { return total; }

    public void adiciona(String tema, String resumo) {
        if (total != LIMITE) { total += 1; }
        
        temas[cursor] = tema;
        resumos[cursor] = resumo;

        /* Verifica se é preciso começar a sobrescrever os primeiros resumos */
        if (cursor != LIMITE - 1) { cursor += 1; }
        else { cursor = 0; }
    }

    /* Retorna uma lista contendo todos os resusmos com os seus temas */
    public String[] pegaResumos() {
        String[] lista = new String[total];
        for (int i = 0; i != total; i++)
            lista[i] = temas[i] + ": " + resumos[i];
        return lista;
    }

    /*
     * Retorna uma String que contem todos os temas abordados nos resumos
     * separaso pro uma barra
     */
    public String imprimeResumos() {
        String retorno = new String();
        retorno += String.format("- %d resumo(s) encontrado(s) \n- ", total);

        String[] suporte = new String[total];
        for (int i = 0; i != total; i++)
            suporte[i] = temas[i];

        return retorno + String.join(" | ", suporte);
    }

    /* Verfica se um tema especifico já foi abordado em algum resumo */
    public boolean temResumo(String tema) {
        for (int i = 0; i != total; i++)
            if (temas[i].equals(tema)) 
                return true;
        return false;
    }
}
