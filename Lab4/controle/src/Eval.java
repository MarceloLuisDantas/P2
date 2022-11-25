package controle.src;

public class Eval {
    public static void eval(String escolha, Controle controle) {
        if (escolha.equals("c")) {
            String matricula = Utils.input("Matricula do aluno: ");
            String curso     = Utils.input("Curso do aluno: ");
            String nome      = Utils.input("Nome do aluno: ");
            controle.addAluno(matricula, curso, nome);

        } else if ((escolha.equals("e"))) {
            String matricula = Utils.input("Matricula: ");
            System.out.println(controle.consultaAluno(matricula));

        } else if ((escolha.equals("n"))) {
            String tema = Utils.input("Tema do grupo: ");
            int tamanho = Utils.inputInt("Vagas do grupo: ");
            if (controle.addGrupo(tema, tamanho)) 
                System.out.println("Grupo criado com sucesso");
            else 
                System.out.println("Grupo já existente");

        } else if ((escolha.equals("a"))) {
            String matricula = Utils.input("Matricula: ");
            String grupo = Utils.input("Grupo: ");
            System.out.println(controle.addAlunoToGrupo(matricula, grupo));
            
        } else if ((escolha.equals("o"))) {
            String matricula = Utils.input("Matricula: ");
            String[] result = controle.consultaAlunoGrupos(matricula);
            for (String i : result) 
                System.out.println(i);
                
        } else if ((escolha.equals("l"))) {
            String grupo = Utils.input("Grupo: ");
            String[] result = controle.consultaGrupoAlunos(grupo);
            for (String i : result) 
                System.out.println(i);

        } else if ((escolha.equals("r"))) {
            String matricula = Utils.input("Matricula: ");
            System.out.println(controle.addAlunoToRespodneram(matricula));

        } else if ((escolha.equals("i"))) {
            String[] result = controle.listaAlunosResponderam();
            System.out.println("Alunos que responderam: ");
            for (String i : result) 
                System.out.println(i);

        } else if ((escolha.equals("m"))) {
            controle.estatisticas();

        } else if ((escolha.equals("s"))) {
            System.out.println("Fechando programa");
            System.exit(0);

        } else {
            System.out.println("Comando não reconhecido");
        }
    }
}
