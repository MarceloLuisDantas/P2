package controle;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private List<String> grupos = new ArrayList<String>(); 
    private String matricula; 
    private String curso; 
    private String nome;

    Aluno(String matricula, String curso, String nome) {
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
    }

    public String getCurso() {
        return this.curso;
    }

    public String getNome() {
        return this.nome;
    }

    public String[] getGrupos() {
        return grupos.toArray(new String[grupos.size()]);
    }

    public int totalGrupos() {
        return grupos.size();
    }

    public String toString() {
        return String.format("%s - %s - %s", matricula, nome, curso);
    }

    public boolean equals(Aluno aluno) {
        return this.matricula == aluno.matricula;
    }
    
    public String getMatricula() { 
        return this.matricula; 
    }
    
    public boolean addGrupo(String tema) {
        if (!grupos.contains(tema)) {
            return grupos.add(tema); 
        } return false;
    }
   
    public boolean rmvGrupo(String tema) {
        if (grupos.contains(tema)) {
            return grupos.remove(tema); 
        } return false;
    }
}
