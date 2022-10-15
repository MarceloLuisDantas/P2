package coisarepl.funcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import coisarepl.IO;

public class Resumo extends Command {
    public Resumo(String comando, String[] argumentos) {
        super(comando, argumentos);
    }

    public static Boolean checkSintaxDelete(String[] args) {
        return args[2].contains(" ");    
    }

    public static Boolean checkSintaxListar(String [] args) {
        return args[2].contains(" ");    
    }

    public static Boolean checkParenteses(String[] linha) {        
        List<Integer> parenteses = new ArrayList<Integer>();
        for (String p : linha) {
            if (parenteses.size() == 3) { break; }
            if (p.contains("("))        { parenteses.add(0); } 
            if (p.contains(")"))        { parenteses.add(1); }

            if (p.contains("\"") && parenteses.size() < 2) {
                return false;
            }
        }   
        if (parenteses.size() != 2) 
            return false; 
        else if (parenteses.get(0) != 0 && parenteses.get(1) != 1) 
            return false;
        else 
            return true;
    }

    public static Boolean checkAspas(String[] linha) {
        String x = String.join(" ", linha);
        int total = Arrays.asList(x.split("")).stream().count("\"");
    }

    public static String clear(String palavra) {
        String[] letras = palavra.split("");
        if (letras[0].equals("(") || letras[0].equals("\"") ) 
            return palavra.substring(1); 
        else if (letras[letras.length - 1].equals(")") || 
                 letras[letras.length - 1].equals("\"")) {
            return palavra.substring(0, letras.length - 1); 
        } 
        return palavra;
    }

    public static int[] getIndicesIntervalo(String[] args) {
        int[] indices = new int[2];
        int sup = 0;
        for (int i = 0; i != args.length; i++) {
            if (args[i].contains("\"")){
                indices[sup] = i;
                sup++;
            }
        }
        return indices;
    }

    public static String getResumo(String[] args) {
        int[] indices = getIndicesIntervalo(args);
        if (indices[1] == 0) { return ""; }

        String resumo = new String();
        for (int i = indices[0]; i != indices[1] + 1; i++) 
            resumo += clear(args[i]) + " ";
        return resumo.trim();
    }

    public static String[] getTags(String[] args) {
        List<String> tags = new ArrayList<String>();
        Boolean save = false;
        Boolean stop = false;
        for(String p : args) {
            if (stop) { break; }
            else if (p.contains("(")) { save = true; } 
            else if (p.contains(")")) { stop = true; }

            if (save) { tags.add(clear(p)); }
        }

        String[] tags_array = new String[tags.size()];
        for (int i = 0; i != tags.size(); i++) 
            tags_array[i] = tags.get(i);

        return tags_array;
    }

    // private Boolean checkSintaxNovo() {
    //     String[] args = Arrays.copyOfRange(argumentos, 2, argumentos.length); 
    //     if (checkParenteses(args))
    // }

    public static Boolean checkSintax(String[] args) { 
        if (args.length < 2) { return false; }
        if (args.length == 2) { return args[1].equals("listar"); }
        
        String[] acoes = { "novo", "delete", "listar", "alterar" };
        boolean existe = false;
        for (String a : acoes) 
            if (a.equals(args[1])) 
                existe = true;

        if (!existe) { return false; }
        String acao = args[1]; 

        if (!checkSintaxDelete(args)) { return false; }
        if (!checkSintaxListar(args)) { return false; }

        return true;
    };
    public void execute() {};
    public void help() {
        IO.println("Comando: Resumo");
        IO.println("Sintaxe: ");
        IO.println("  - Resumo novo [nome] ([tags]) '[texto]'");
        IO.println("    - Ira salvar um novo resumo com o nome, tags e texto");
        IO.println("    - Um nome não pode ter o mesmo nome de uma tag");
        IO.println("  - Resumo delete [nome]");
        IO.println("    - Ira deletar o resumo com o nome passado");
        IO.println("  - Resumo delete [tag]");
        IO.println("    - Ira deletar uma tag da lista de tags");
        IO.println("  - Resumo listar [tag]");
        IO.println("    - Ira listar todos os resumos com a mesma tag");
        IO.println("  - Resumo listar");
        IO.println("    - Ira listar todos os resumos");
        IO.println("  - Resumo alterar [nome] ([novas tags]) '[novo texto]'");
        IO.println("    - Ira alterar o texto e as tags do resumo");
        IO.println("  - Resumo alterar [nome] '[novo texto]'");
        IO.println("    - Ira alterar o texto do resumo");
        IO.println("");
    };
}
