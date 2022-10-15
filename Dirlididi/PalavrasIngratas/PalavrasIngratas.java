/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class PalavrasIngratas {
    static boolean ingrata(String palavra) {
        List<String> vogais = Arrays.asList("aeiou".split(""));
        List<String> vogais_palavra = 
            Arrays.asList(palavra.split(""))
                  .stream()
                  .filter(x -> vogais.contains(x))
                  .collect(Collectors.toList());

        return vogais_palavra.size() == 0;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        List<String> palavras = new ArrayList<String>();

        while (palavras.size() != 3) {
            String palavra = sc.next();
            if (ingrata(palavra)) 
                palavras.add(palavra);
        }
        
        for (String p : palavras) 
            System.out.println(p);

        sc.close();
    }
}
