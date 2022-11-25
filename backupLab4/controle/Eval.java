package controle;

public class Eval {
    public static void eval(String escolha, Controle controle) {
        if (escolha.equals("c")) {
            controle.addAluno();
        } else if ((escolha.equals("e"))) {
            controle.consultaAluno();
        } else if ((escolha.equals("n"))) {
            controle.addGrupo();
        } else if ((escolha.equals("a"))) {
            controle.addAlunoToGrupo();
        } else if ((escolha.equals("o"))) {
            controle.consultaAlunoGrupos();
        } else if ((escolha.equals("l"))) {
            controle.consultaGrupoAlunos();
        } else if ((escolha.equals("r"))) {
            controle.addAlunoToRespodneram();
        } else if ((escolha.equals("i"))) {
            controle.listaAlunosResponderam();
        } else if ((escolha.equals("m"))) {
            controle.listaAlunosResponderam();
        } else if ((escolha.equals("s"))) {
            System.out.println("Fechando programa");
            System.exit(0);
        } else {
            System.out.println("Comando não reconhecido");
        }
    }
}
