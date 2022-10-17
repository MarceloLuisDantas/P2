package coisarepl.funcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import coisarepl.IO;

public class Resumo extends Command {
    public Resumo(String comando, String[] argumentos) {
        super(comando, argumentos);
    }

    public static Boolean checkSintaxeDelete(String[] args) {
        return args[2].contains(" ");    
    }

    public static Boolean checkSintaxeListar(String [] args) {
        return args[2].contains(" ");    
    }

    public static String getResumo(String[] args) {
        int[] indices = Utils.getIndicesIntervalo(args);
        if (indices[1] == 0) { return ""; }

        String resumo = new String();
        for (int i = indices[0]; i != indices[1] + 1; i++) 
            resumo += Utils.clear(args[i]) + " ";
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

            if (save) { tags.add(Utils.clear(p)); }
        }

        String[] tags_array = new String[tags.size()];
        for (int i = 0; i != tags.size(); i++) 
            tags_array[i] = tags.get(i);

        return tags_array;
    }

    public static Boolean checkSintaxeNovo(String[] args) {
        return (Utils.checkParenteses(args) && Utils.checkAspas(args)); 
    }

    public static Boolean checkSintaxeAlterar(String[] args) {
        if (Utils.checkAspas(args)) {
            
        } return false;
    }

    public static Boolean checkSintaxe(String[] args) { 
        if (args.length < 2) { return false; }
        else if (args.length == 2) { return args[1].equals("listar"); }
        

        
        

        return true;
    };
    public void execute() {};
    public void help() {
        IO.println("Comando: Resumo");
        IO.println("Sintaxee: ");
        IO.println("  - Resumo novo [nome] ([tags]) \"[texto]\"");
        IO.println("    - Ira salvar um novo resumo com o nome, tags e texto");
        IO.println("    - Um nome não pode ter o mesmo nome de uma tag");
        IO.println("  - Resumo alterar [nome] ([novas tags]) \"[novo texto]\"");
        IO.println("    - Ira alterar o texto e as tags do resumo");
        IO.println("  - Resumo alterar [nome] '[novo texto]'");
        IO.println("    - Ira alterar o texto do resumo");
        IO.println("  - Resumo delete [nome]");
        IO.println("    - Ira deletar o resumo com o nome passado");
        IO.println("  - Resumo listar [tag]");
        IO.println("    - Ira listar todos os resumos com a mesma tag");
        IO.println("  - Resumo listar");
        IO.println("    - Ira listar todos os resumos");
        IO.println("");
    };
}
