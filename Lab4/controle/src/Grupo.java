package controle.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por representar e guardar informaçõe sobre os grupos
 * 
 * @author Marcelo Dantas
 */
public class Grupo {
    private List<String> alunos = new ArrayList<String>();
    private String tema;
    private int tamanho;

    public Grupo(String tema, int tamanho) {
        this.tema = tema;
        this.tamanho = tamanho;
    }

    public boolean equals(Grupo grupo) {
        return this.tema == grupo.tema;
    }
    
    public String toString() {
        return String.format("%s %d/%d", 
            Utils.capitalize(tema), alunos.size(), tamanho);
    }

    public boolean cheio() {
        return alunos.size() == tamanho;
    }

    public String[] getAlunos() {
        return alunos.toArray(new String[alunos.size()]);
    }

    public boolean addAluno(String matricula) { 
        if (!alunos.contains(matricula) && !cheio()) {
            return alunos.add(matricula); 
        } return false;
    }
}
