/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UltimaVogal {
    static Scanner sc = new Scanner(System.in);
    static List<String> add_vogais(List<String> lista) {
        String[] p = sc.next().split("");
        if ("aeiou".contains(p[p.length - 1])) 
            lista.add(p[p.length - 1]);
        
        return lista;
    }
    public static void main(String[] args) {
        List<String> vogais = new ArrayList<String>();

        vogais = add_vogais(vogais);
        vogais = add_vogais(vogais);
        vogais = add_vogais(vogais);
        vogais = add_vogais(vogais);
        vogais = add_vogais(vogais);

        for (String i : vogais) 
            System.out.print(i);
    }
}
