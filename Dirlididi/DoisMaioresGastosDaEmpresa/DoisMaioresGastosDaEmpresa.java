/**
* Laboratorio Programação 1 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DoisMaioresGastosDaEmpresa {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> get_lista_int() {
        List<Integer> valores = 
            Arrays.asList(sc.nextLine().split(" "))
                  .stream()
                  .map(Integer::valueOf)
                  .collect(Collectors.toList());
        return valores;
    }
    public static void main(String[] args) {
        List<Integer> v = get_lista_int(); 
        Collections.sort(v);
        System.out.println((v.get(v.size() - 1) + v.get(v.size() - 2)));
        sc.close();
    }
}
