/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class PalavrasPoéticas {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
        String[] p1 = input.next().split("");
        String[] p2 = input.next().split("");

        if (p1[0].equals(p2[0]) && p1[p1.length - 1].equals(p2[p2.length - 1]))
            System.out.println("S");
        else 
            System.out.println("N");
        
        input.close();
    }
}
