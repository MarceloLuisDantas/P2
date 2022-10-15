/**
* Laboratorio 1 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbaixoAssinado {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        List<Integer> valores = new ArrayList<Integer>();
        
        while (true) {
            String[] entrada = sc.nextLine().split(" ");
            if (entrada[0].equals("fim"))
                break;
        
                valores.add(Integer.valueOf(entrada[1]));
        }

        System.out.println(valores.size());
        System.out.println((
            valores.stream().reduce(0, Integer::sum) / valores.size()
        ));
        
        sc.close();
    }
}
