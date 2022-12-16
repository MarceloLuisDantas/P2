package desafios;

import java.util.ArrayList;
import java.util.List;

public class Controler {
    private List<Integer> acoes_completas = new ArrayList<Integer>();
    private ControlerDesafio desafios;
    private ControlerAcao acoes;

    public void add_desafio(String[] tokens) { desafios.add_desafio(tokens); }
    public void add_acao(String[] tokens) { acoes.add_acao(tokens); }

    public void show_desafio(int indice) { 
        System.out.println(desafios.exibi_desafio(indice));
    }
    public void show_acao(int id) {
        System.out.println(acoes.exibi_acao(id));
    } 

    public void progresso_acao(int id_acao, int total) {
        if (!acoes_completas.contains(id_acao)) {
            if (acoes.add_progresso(id_acao, total)) {
                int id_desafio = acoes.getAcao(id_acao).getDesafioId();
                desafios.add_execucao(id_desafio);
                acoes_completas.add(id_acao);
                System.out.println("Acão completada com sucesso"); 
            } 
        }
        System.out.println("Acoes já compeltadas não podem ser alteradas");
    }

    public void lista_acoes() {
        List<Acao> lista = acoes.acoes_ordenadas();
        for (Acao a : lista) {
            int id_acao    = a.getId();
            String data    = a.getData();
            int id_desafio = a.getDesafioId();
            String titulo  = desafios.getDesafio(id_desafio).getTitulo();
            int progresso  = a.getProgresso();
            
            System.out.println(
                "Acao " + id_acao + " - " + data + " " + 
                titulo + " - Progresso " + progresso
            );
        }
    }

}
