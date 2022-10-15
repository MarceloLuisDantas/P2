/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GastoDe4Semanas {
    static Scanner sc = new Scanner(System.in);

    static List<Integer> get_dia() {
        List<Integer> valores = 
            Arrays.asList(sc.nextLine().split(" "))
                  .stream()
                  .map(Integer::valueOf)
                  .collect(Collectors.toList());
        return valores;
    }

    static int max(List<Integer> lista) {
        return lista.stream().reduce(0, Integer::max);
    }

    static int min(List<Integer> lista) {
        return lista.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    static int sum(List<Integer> lista) {
        return lista.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> semana1 = get_dia();
        System.out.println(sum(semana1) + " " + min(semana1) + " " + max(semana1));
        
        List<Integer> semana2 = get_dia();
        System.out.println(sum(semana2) + " " + min(semana2) + " " + max(semana2));
        
        List<Integer> semana3 = get_dia();
        System.out.println(sum(semana3) + " " + min(semana3) + " " + max(semana3));
        
        List<Integer> semana4 = get_dia();
        System.out.println(sum(semana4) + " " + min(semana4) + " " + max(semana4));

        sc.close();
    }
}
