/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        int numero = sc.nextInt();

        while (true) {
            int chute = sc.nextInt();
            if (chute == numero) 
                break;
                
            System.out.println(((chute > numero) ? "MAIOR" : "MENOR"));
        }

        System.out.println("ACERTOU");
        sc.close();
    }
}
