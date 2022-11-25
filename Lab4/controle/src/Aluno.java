package controle.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavem por representar e armazenar dados 
 * referentes a alunos
 * 
 * @author Marcelo Dantas
 */
public class Aluno {
    private List<String> grupos = new ArrayList<String>(); 
    private String matricula; 
    private String curso; 
    private String nome;

    public Aluno(String matricula, String curso, String nome) {
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
    
    public String getMatricula() { 
        return this.matricula; 
    }
    
    public String[] getGrupos() {
        return grupos.toArray(new String[grupos.size()]);
    }

    public int totalGrupos() {
        return grupos.size();
    }

    public String toString() {
        return String.format("%s - %s - %s", 
            Utils.capitalize(matricula), 
            Utils.capitalize(nome), 
            Utils.capitalize(curso));
    }

    public boolean equals(Aluno aluno) {
        return this.matricula == aluno.matricula;
    }
    
    public boolean addGrupo(String tema) {
        if (!grupos.contains(tema)) {
            return grupos.add(tema); 
        } return false;
    }
}
