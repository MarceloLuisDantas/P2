package controle;

public class Main {
    private static String menu() {
        return """
(C)adastrar Aluno.
(E)xibir Aluno.
(N)ovo Grupo.
(A)locar Aluno no Grupo e Verificar pertinência a Grupos.
(O)lhaí quais Grupos o Aluno Tá.
(L)istar alunos em um Grupo.
(R)egistrar Aluno que Respondeu.
(I)mprimir Alunos que Responderam.
(M)ostrar Estatísticas.
(S)air!
""";
    }

    private static void cls() {
        IO.cls();
        System.out.println("");
        System.out.println("Controle de Grupos e Alunos: ");
        System.out.println("");
    }

    public static void main(String[] args) {
        Controle controle = new Controle();
        cls();
        while (true) {
            System.out.println(menu());
            String escolha = IO.input("Opção> ");
            Eval.eval(escolha, controle);
            System.out.println("");
            System.out.println("--------------------");
            System.out.println("");
        }
    }
}