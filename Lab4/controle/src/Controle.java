package controle.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe responsavel por gerenciar e analisar dados 
 * sobre alunos, grupos e gerar suas
 * 
 * @author Marcelo Dantas
 */
public class Controle {
    /** Hahs map que relaciona uma matricula a um aluno */
    private Map<String, Aluno> alunos = new HashMap<String, Aluno>();

    /** Hahs map que relaciona um tema a um grupo */
    private Map<String, Grupo> grupos = new HashMap<String, Grupo>();

    /** Lista das matriculas dos alunos que responderam em ordem */
    private List<String> responderam = new ArrayList<String>();

    /** Lista das matriculas dos alunos */
    private List<String> matriculas = new ArrayList<String>();

    /**
     * Função responsavel por criar e adicionar um novo aluno
     * 
     * @param matricula - Matricula do aluno
     * @param curso - Curso do aluno
     * @param nome - Nome do aluno
     * @return False caso o aluno já existe, e True caso tudo de certo
     */
    public boolean addAluno(String matricula, String curso, String nome) {        
        if (alunos.containsKey(matricula)) {
            System.out.println("Matricula " + matricula + " já cadastrada");
            return false;
        } 

        Aluno aluno = new Aluno(matricula, curso, nome);
        alunos.put(matricula, aluno);
        matriculas.add(matricula);
        return true;
    }

    /**
     * Função responsavel por criar e adicionar um novo grupo
     * 
     * @param tema - Tema do grupo
     * @param tamanho - Vagas disponiveis
     * @return False caso o grupo já existe, true caso contrario
     */
    public boolean addGrupo(String tema, int tamanho) {
        String temaKey = tema.toLowerCase();
        if (grupos.containsKey(temaKey)) {
            System.out.println("Já existe um grupo com tema " + tema);
            return false;
        }

        Grupo grupo = new Grupo(tema, tamanho);
        grupos.put(temaKey, grupo);
        return true;
    }

    /**
     * Função responsavel por adicionar um Aluno a um Grupo
     * 
     * @param matricula - Matricula do aluno
     * @param grupo - Grupo alvo
     * @return Ira retornar uma string um dos resultados a baixo - 
     * Aluno cadastrado com sucesso
     * A matricula do Aluno não foi encontrada. 
     * O Grupo não foi encontrado. 
     * O Grupo esta cheio. 
     * O Aluno já esta cadastrado. 
     */
    public String addAlunoToGrupo(String matricula, String grupo) {
        grupo = grupo.toLowerCase();

        if (!alunos.containsKey(matricula)) 
            return "A matricula do Aluno não foi encontrada";

        if (!grupos.containsKey(grupo)) 
            return "O Grupo não foi encontrado";
        
        if (grupos.get(grupo).cheio()) 
            return "O Grupo esta cheio";
    
        if (!grupos.get(grupo).addAluno(matricula)) 
            return "O Aluno já esta cadastrado";
        
        alunos.get(matricula).addGrupo(grupo);
        return "Aluno cadastrado com sucesso";
    }

    /**
     * Função responsavel por mostrar os dados de um aluno
     * 
     * @param matricula - Matricula do aluno
     */
    public String consultaAluno(String matricula) {
        if (!alunos.containsKey(matricula.toLowerCase())) 
            return "Aluno não cadastrado";
        else 
            return alunos.get(matricula).toString();
    }

    /**
     * Função responsavel por mostrar todos os grupos a qual um 
     * aluno esta matriculado
     * 
     * @param matricula - Matricula do aluno
     * @return Lista com os grupos que o aluno participa
     */
    public String[] consultaAlunoGrupos(String matricula) {
        matricula = matricula.toLowerCase();
        if (!alunos.containsKey(matricula)) {
            return new String[]{"Aluno não cadastrado"};
        } else {
            String[] alunoGrupos = alunos.get(matricula).getGrupos();
            List<String> listaGrupos = new ArrayList<String>();

            System.out.println("Grupos: ");
            for (String i : alunoGrupos) {
                listaGrupos.add(grupos.get(i).toString());

            }

            return listaGrupos.toArray(new String[listaGrupos.size()]);
        }
    }

    /**
     * Função responsavel por mostrar todos os alunos que estão em um curso
     * 
     * @param grupo - Grupo alvo
     * @return Lista dos alunos que estão no grupo
     */
    public String[] consultaGrupoAlunos(String grupo) {
        grupo = grupo.toLowerCase();
        if (!grupos.containsKey(grupo)) {
            return new String[]{"Grupo não cadastrado"};
        } else {
            String[] grupoAlunos = grupos.get(grupo).getAlunos();
            List<String> listaAlunos = new ArrayList<String>();

            System.out.println("Grupos: ");
            for (String i : grupoAlunos) 
                listaAlunos.add(alunos.get(i).toString());
            
            return listaAlunos.toArray(new String[listaAlunos.size()]);
        }
    }

    /**
     * Função responsavel por listar todos os alunos
     * 
     * @return Lista com todos os alunos
     */
    public String[] listaAlunos() {
        List<String> listaAlunos = new ArrayList<String>();
        for (Map.Entry<String, Aluno> set : alunos.entrySet()) 
            listaAlunos.add(set.getValue().toString());
        return listaAlunos.toArray(new String[listaAlunos.size()]);
    }

    /**
     * Função responsavel por adicionar um aluno a lista de respostas
     * 
     * @param matricula - Matricula do aluno
     * @return Resultado da tentativa
     */
    public String addAlunoToRespodneram(String matricula) {
        matricula = matricula.toLowerCase();
        if (!alunos.containsKey(matricula)) {
            return "Aluno não cadastrado";
        } else {
            responderam.add(alunos.get(matricula).toString());
            return "Aluno registrado";
        }
    }

    /**
     * Função responsavel por listar os alunos que estão na lista de resposta
     * 
     * @return Lista dos alunos na lista de resposta
     */
    public String[] listaAlunosResponderam() {
        return responderam.toArray(new String[responderam.size()]);
    }
    
    /**
     * Função responsavel por encontrar o maior numero de grupos em um mesmo aluno
     * 
     * @return a maior quantidade de grupos que um alu participa
     */
    public int maiorQuantidadeDeGrupos() {
        int quantidade = 0;
        for (String a : matriculas) 
            if (alunos.get(a).totalGrupos() > quantidade) 
                quantidade = alunos.get(a).totalGrupos();
        return quantidade; 
    }   

    /**
     * Função responsavel por mostrar o(s) aluno(s) que esta(ão) em mais grupos, 
     * 
     * @return Lista com os alunos com mais participações em grupos
     */
    public String[] alunosEmMaisGrupos() {
        int maior = maiorQuantidadeDeGrupos();
        if (maior == 0) 
            return new String[]{"Nem um aluno cadastrado em nem um grupo"}; 

        List<String> alunosMaior = matriculas.stream()
            .filter(valor -> alunos.get(valor).totalGrupos() == maior)
            .collect(Collectors.toList());
        
        if (alunosMaior.size() > 1) 
            System.out.println("Alunos que estão em mais grupos:");
        else 
            System.out.println("Aluno que esta em mais grupos:");

        List<String> listaAlunos = new ArrayList<String>();
        for (String matricula : alunosMaior) 
            listaAlunos.add(alunos.get(matricula).toString());
        
        return listaAlunos.toArray(new String[listaAlunos.size()]);
    }

    /**
     * Função responsavel por gerar uma lista com todos os cursos
     * 
     * @return lista com os grupos
     */
    public List<String> getCursos() {
        List<String> cursos = new ArrayList<String>();
        for (Map.Entry<String, Aluno> aluno : alunos.entrySet()) 
            cursos.add(aluno.getValue().getCurso());
        return cursos;
    }

    /**
     * Função responsavel por gerar um hash map relacionado um curso com a quantidade 
     * de alunos que estão cursando
     * 
     * @return Hash Map com a chave sendo um grupo e o seu valor a quantidade de alunos
     */
    public Map<String, Integer> getCursoQuantidade() {
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

    /**
     * Função responsavel por mostrar os crusos e quantos alunos estão crusando
     * 
     * @return Lista com strings formatadas em {Curso} : {Quantidade de alunos}
     */
    public String[] cursos() {
        List<String> lista = new ArrayList<String>();
        for (Map.Entry<String, Integer> set : getCursoQuantidade().entrySet())
            lista.add(String.format("%s : %d Aluno(s)", set.getKey(), set.getValue()));
        return lista.toArray(new String[lista.size()]);
    }

    /**
     * Função responsavel por listar os alunos que estão sem grupos
     * 
     * @return Lista dos alunos sem grupos
     */
    public String[] alunosSemGrupos() {
        List<String> lista = new ArrayList<String>();
        for (Map.Entry<String, Aluno> set : alunos.entrySet()) 
            if (set.getValue().totalGrupos() == 0) 
                lista.add(set.getValue().toString());

        return lista.toArray(new String[lista.size()]);
    }

    /**
     * Função responsavel por demonstrar as estatisticas dos alunos.
     * Alunos que estão em mais grupos, os cursos e quantos alunos estão em cada e os 
     * alunos que não estão em nem um grupo.
     */
    public void estatisticas() {
        System.out.println();
        for (String i : alunosEmMaisGrupos())
            System.out.println(i);

        System.out.println();
        for (String i : cursos())
            System.out.println(i);

        System.out.println();
        for (String i : alunosSemGrupos())
            System.out.println(i);               
    }
}
