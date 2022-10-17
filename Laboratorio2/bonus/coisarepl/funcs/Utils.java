package coisarepl.funcs;

import java.util.ArrayList;
import java.util.List;

public class Utils {
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

        if (parenteses.size() < 2)
            return false; 
        else if (parenteses.get(0) == 0 && parenteses.get(1) == 1) 
            return true; 
        return false;
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

    public static Boolean checkAspas(String[] linha) {
        String[] letras = String.join(" ", linha).split("");
        if (!letras[letras.length - 1].equals("\"")) { return false; }
        
        int aspas_total = 0;
        for (String letra : letras) 
            if (letra.equals("\"")) 
                aspas_total++; 
        
        return aspas_total == 2;
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

    
}
