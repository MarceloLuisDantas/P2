package lab2;

/**
* Registo do tempo preciso para certa cadeira e quanto tempo
* já foi disposto pelo aluno a cadeira
* 
* @author Marcelo Dantas
*/
public class RegistroTempoOnline {
    /* Nome da cadeiras */
    private String nome;
    /* Total de horas percoridas */
    private int horasTotal;
    /* Total de horas necessarias */
    private int horasPrecisas;
    
    RegistroTempoOnline(String nome, int horas) {
        this.nome = nome;
        this.horasPrecisas = horas;
    }

    RegistroTempoOnline(String nome) {
        this.nome = nome;
        this.horasPrecisas = 120;
    }

    /**
     * Metodo responsavel por adicionar ao tempo total tempo online
     * 
     * @param valor - valor de horas a serem adicionados 
     */
    public void adicionaTempoOnline(int valor) { 
        this.horasTotal += valor; 
    }

    /**
     * Metodo responsavel por verificar se a meta de horas já foi atingida
     * 
     * @return Boolean - Resultado se o total foi atingido
     */
    public Boolean atingiuMetaTempoOnline() { 
        return this.horasTotal >= this.horasPrecisas; 
    }

    /**
     * Retorna uma String que demonstre o progreço da cadeira 
     * 
     * @return String - String formatada como "[nome] [horas percorridas]/[horas precisas]""
     */
    public String toString() {
        return String.format("%s %d/%d", nome, this.horasTotal, this.horasPrecisas);
    }
}
