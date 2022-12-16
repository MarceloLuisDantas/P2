package desafios;

public class Eval {
    private Controler controler = new Controler();

    private String getTituloDesafio(String linha) {
        String[] tokens1 = linha.split("“");
        return tokens1[1].split("”")[0];
    }

    private String add_desafio(String linha) {
        String titulo = "“" + getTituloDesafio(linha) + "”";
        String descricao = "";
        if (controler.add_desafio(new String[]{"", titulo, descricao})) {
            Integer indice = controler.get_poss(titulo);
            return "Indice do Desafio: " + indice.toString();
        }
        return "Desafio com mesmo titulo cadastrado";
    }

    private String add_acao(String[] tokens) {
        if (controler.add_acao(tokens)) 
            return "Ação cadastrada com sucesso";
        return "Ação com mesmo ID já cadastrado";
    }

    private String progresso(String[] tokens) {
        int id_acao = Integer.parseInt(tokens[1]);
        int total = 0;
        if (tokens.length >= 3) 
            total = Integer.parseInt(tokens[2]);
        return controler.progresso_acao(id_acao, total);
    }

    private String lista() {
        controler.lista_acoes();
        return "";
    } 

    public String eval(String linha) {
        String[] tokens = linha.split(" ");
        String comando = tokens[0];
        if (comando.equals("ADD_DESAFIO"))
            return add_desafio(linha);
        
        else if (comando.equals("ADD_ACAO")) 
            return add_acao(tokens);
        
        else if (comando.equals("EXIBIR_DESAFIO")) 
            return controler.show_desafio(Integer.parseInt(tokens[1]));
        
        else if (comando.equals("EXIBIR_ACAO")) 
            return controler.show_acao(Integer.parseInt(tokens[1]));
        
        else if (comando.equals("PROGRESSO_ACAO")) 
            return progresso(tokens);
        
        else if (comando.equals("LISTAR_ACAO_POR_ORDEM_PROGRESSO")) 
            return lista();
        
        else 
            return "Comando não registrado";
        
    }
}
