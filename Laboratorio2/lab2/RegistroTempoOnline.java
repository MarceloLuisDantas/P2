package lab2;

/**
* Registo do tempo preciso para certa cadeira e quanto tempo
* já foi disposto pelo aluno a cadeira
* 
* @author Marcelo Dantas
*/
public class RegistroTempoOnline {
    private String nome;
    private int hTotal;
    private int hPrecias;
    
    RegistroTempoOnline(String nome, int horas) {
        this.nome = nome;
        this.hPrecias = horas;
    }

    RegistroTempoOnline(String nome) {
        this.nome = nome;
        this.hPrecias = 120;
    }

    public void adicionaTempoOnline(int valor) { hTotal += valor; }
    public Boolean atingiuMetaTempoOnline() { return hTotal >= hPrecias; }

    /*
     * Retorna uma String que demonstre o progreço da cadeira 
     * 
     * [nome] [horas percorridas]/[horas precisas]
     */
    public String toString() {
        return String.format("%s %d/%d", nome, hTotal, hPrecias);
    }
}
