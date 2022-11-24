package controle;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<String> alunos = new ArrayList<String>();
    private String tema;
    private int tamanho;

    Grupo(String tema, int tamanho) {
        this.tema = tema;
        this.tamanho = tamanho;
    }

    public boolean equals(Grupo grupo) {
        return this.tema == grupo.tema;
    }
    
    public String toString() {
        return String.format("%s %d/%d", tema, alunos.size(), tamanho);
    }
    
    public boolean cheio() {
        return alunos.size() == tamanho;
    }

    public String[] getAlunos() {
        return alunos.toArray(new String[alunos.size()]);
    }

    public boolean addAluno(String matricula) { 
        if (!alunos.contains(matricula)) {
            return alunos.add(matricula); 
        } return false;
    }
    
    public boolean rmvAluno(String matricula) { 
        if (alunos.contains(matricula)) {
            return alunos.remove(matricula); 
        } return false;
    }
}
