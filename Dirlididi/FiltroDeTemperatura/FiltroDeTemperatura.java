/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class FiltroDeTemperatura {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        int errados = 0;

        while (true) {
            int entrada = sc.nextInt();
            if (entrada == 0 )
                break;
                
            if (entrada < 0)
                errados += 1;
        }

        System.out.println(errados);
        sc.close();
    }
}
