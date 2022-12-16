package desafios;

import java.util.List;

/**
 * Classe responsavel pelo controle geral de desafios e ações
 */
public class Controler {
    // Controle dos desafios
    private ControlerDesafio desafios = new ControlerDesafio(); 
    // Controle das ações
    private ControlerAcao acoes = new ControlerAcao();          

     /**
     * Cria um novo desafio
     * 
     * @param tokens Lista de Tokens contendo as informações necessarias
     * tokens[1] Titulo do desafio, 
     * tokens[2] Descrição do desafio, 
     * @return Se o desafio foi cadastrado ou se já existia um com mesmo titulo 
     */
    public boolean add_desafio(String[] tokens) { 
        return desafios.add_desafio(tokens); 
    }

    /**
     * Cria uma nova ação
     * 
     * @param tokens Lista de Tokens contendo as informações necessarias
     * tokens[1] Id do desafio, 
     * tokens[2] Data de inicio da Ação, 
     * tokens[3] Id da Ação
     * @return Se a acao foi cadastrada ou se já existia uma com mesmo ID
     */
    public boolean add_acao(String[] tokens) { 
        return acoes.add_acao(tokens); 
    }

    public int get_poss(String titulo) {
        return desafios.get_poss(titulo);
    }

    /**
     * Mostra a representação de um Desafio
     * 
     * @param indice Indice do desafio na lista 
     * @return String contendo a representação do desafio
     */
    public String show_desafio(int indice) { 
        return desafios.exibi_desafio(indice);
    }

    /**
     * Retorna a representação de uma Ação
     * 
     * @param id Id da ação 
     * @return String contendo a representação da ação
     */
    public String show_acao(int id) {
        return acoes.exibi_acao(id);
    } 

    /**
     * Incrementa o progresso de uma ação. Quando uma anção é atinge 100 de progresso ela é adicionada a lista de ações completadas, e não podera mais ser alterada.
     * 
     * @param id_acao Id da ação
     * @param total Total a ser incrementado
     * @return Mensagem sobre o estado da ação
     */
    public String progresso_acao(int id_acao, int total) {
        if (!acoes.existeAcao(id_acao)) 
            return "ID não catalogado";
            
        if (!acoes.acao_completa(id_acao)) {
            if (acoes.add_progresso(id_acao, total)) {
                int id_desafio = acoes.getAcao(id_acao).getDesafioId();
                desafios.add_execucao(id_desafio - 1);
                return "Acão completada com sucesso"; 
            } 
            return "Progresso realizado";
        }
        return "Ações já compeltadas não podem ser alteradas";
    }

    /**
     * Lista todas as ações em ordenadas pelo progresso
     */
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
