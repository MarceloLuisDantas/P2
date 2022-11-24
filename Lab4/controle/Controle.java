package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controle {
    private Map<String, Aluno> alunos = new HashMap<String, Aluno>();
    private Map<String, Grupo> grupos = new HashMap<String, Grupo>();
    private List<String> responderam = new ArrayList<String>();
    private List<String> matriculas = new ArrayList<String>();

    public boolean addAluno() {
        String matricula = IO.input("Matricula do aluno: ");
        String curso     = IO.input("Curso do aluno: ");
        String nome      = IO.input("Nome do aluno: ");

        if (alunos.containsKey(matricula)) {
            System.out.println("Matricula " + matricula + " já cadastrada");
            return false;
        } 

        Aluno aluno = new Aluno(matricula, curso, nome);
        alunos.put(matricula, aluno);
        matriculas.add(matricula);
        return true;
    }

    public boolean addGrupo() {
        String tema = IO.input("Tema do grupo: ");
        int tamanho = IO.inputInt("Vagas do grupo: ");

        if (grupos.containsKey(tema)) {
            System.out.println("Já existe um grupo com tema " + tema);
            return false;
        }

        Grupo grupo = new Grupo(tema, tamanho);
        grupos.put(tema, grupo);
        return true;
    }

    public boolean addAlunoToGrupo() {
        String matricula = IO.input("Matricula: ");
        if (!alunos.containsKey(matricula)) {
            System.out.println("Matricula não encontrada");
            return false;
        }

        String grupo = IO.input("Grupo: ");
        if (!grupos.containsKey(grupo)) {
            System.out.println("Grupo não encontrado");
            return false;
        }
        
        if (grupos.get(grupo).cheio()) {
            System.out.println("Grupo cheio");
            return false;
        }

        if (!grupos.get(grupo).addAluno(matricula)) {
            System.out.println("Aluno já cadastrado no grupo");
            return false;
        } 

        alunos.get(matricula).addGrupo(grupo);
        return true;
    }

    public void consultaAluno() {
        String matricula = IO.input("Matricula: ");
        if (!alunos.containsKey(matricula)) {
            System.out.println("Aluno não cadastrado");
        } else {
            System.out.println(alunos.get(matricula).toString());
        }
    }

    public void consultaAlunoGrupos() {
        String matricula = IO.input("Matricula: ");
        if (!alunos.containsKey(matricula)) {
            System.out.println("Aluno não cadastrado");
        } else {
            String[] alunoGrupos = alunos.get(matricula).getGrupos();
            System.out.println("Grupos: ");
            for (String i : alunoGrupos) {
                String gString = grupos.get(i).toString();
                System.out.println("- " + gString);
            }
        }
    }

    public void consultaGrupoAlunos() {
        String grupo = IO.input("Grupo: ");
        if (!grupos.containsKey(grupo)) {
            System.out.println("Aluno não cadastrado");
        } else {
            String[] grupoAlunos = grupos.get(grupo).getAlunos();
            System.out.println("Grupos: ");
            for (String i : grupoAlunos) {
                String aString = alunos.get(i).toString();
                System.out.println("- Aluno: " + aString);
            }
        }
    }

    public void listaAlunos() {
        System.out.println("Alunos: ");
        for (int i = 0; i != matriculas.size(); i++) 
            System.out.println(
                (i + 1) + ". Aluno: " + alunos.get(matriculas.get(i)).toString());
    }

    public void addAlunoToRespodneram() {
        String matricula = IO.input("Matricula: ");
        if (!alunos.containsKey(matricula)) {
            System.out.println("Aluno não cadastrado");
        } else {
            responderam.add(alunos.get(matricula).toString());
            System.out.println("Aluno registrado");
        }
    }

    public void listaAlunosResponderam() {
        if (responderam.size() <= 0) {
            System.out.println("Nem um aluno respondeu"); 
        } else {
            int count = 1;
            System.out.println("Alunos: ");
            for (String m : responderam) {
                System.out.println(count + ". " + m);
            }
        }
    }
    
    private int maiorQuantidadeDeGrupos() {
        int quantidade = 0;
        for (String a : matriculas) 
            if (alunos.get(a).totalGrupos() > quantidade) 
                quantidade = alunos.get(a).totalGrupos();
        return quantidade; 
    }   

    private void alunosEmMaisGrupos() {
        int maior = maiorQuantidadeDeGrupos();
        List<String> alunosMaior = matriculas.stream()
            .filter(valor -> alunos.get(valor).totalGrupos() == maior)
            .collect(Collectors.toList());
        
        if (alunosMaior.size() > 1) 
            System.out.println("Alunos que estão em mais grupos:");
        else 
            System.out.println("Aluno que esta em mais grupos:");

        int count = 1;
        for (String matricula : alunosMaior) {
            System.out.println(count + "º - " + alunos.get(matricula).toString());
            count += 1;
        }
    }

    private List<String> getCursos() {
        List<String> cursos = new ArrayList<String>();
        for (Map.Entry<String, Aluno> aluno : alunos.entrySet()) 
            cursos.add(aluno.getValue().getCurso());
        return cursos;
    }

    private Map<String, Integer> getCursoQuantidade() {
        List<String> cursos = getCursos();

        Map<String, Integer> cursoQuantidade = new HashMap<String, Integer>();
        for (String curso : cursos)
            cursoQuantidade.put(curso, 0);

        for (Map.Entry<String, Aluno> aluno : alunos.entrySet()) {
            String curso = aluno.getValue().getCurso();
            cursoQuantidade.put(curso, cursoQuantidade.get(curso) + 1);
        }

        return cursoQuantidade;
    }

    private void cursos() {
        for (Map.Entry<String, Integer> set : getCursoQuantidade().entrySet())
            System.out.println(set.getKey() + " : " + set.getValue() + " Alunos ");
    }

    private void alunosSemGrupos() {
        System.out.println("Alunos sem grupos: ");
        int count = 0;
        for (Map.Entry<String, Aluno> set : alunos.entrySet()) 
            if (set.getValue().totalGrupos() == 0) {
                System.out.println(set.getValue().getNome());
                count += 1;
            }
        System.out.println(count + " alunos sem grupos");
    }

    public void estatisticas() {
        alunosEmMaisGrupos();
        cursos();
        alunosSemGrupos();
    }
}
