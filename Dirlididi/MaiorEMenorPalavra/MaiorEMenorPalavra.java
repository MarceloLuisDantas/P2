/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class MaiorEMenorPalavra {

    static String maior(String p1, String p2) {
        return (p1.length() >= p2.length()) ? p1 : p2;
    }
    static String menor(String p1, String p2) {
        return (p1.length() <= p2.length()) ? p1 : p2;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    
        String p1 = sc.next();            
        String maior = p1;
        String menor = p1;
        
        String p2 = sc.next();        
        maior = maior(maior, p2);
        menor = menor(menor, p2);
        
        String p3 = sc.next();        
        maior = maior(maior, p3);
        menor = menor(menor, p3);
        
        String p4 = sc.next();        
        maior = maior(maior, p4);
        menor = menor(menor, p4);
        
        String p5 = sc.next();        
        maior = maior(maior, p5);
        menor = menor(menor, p5);
        
        System.out.println(menor);
        System.out.println(maior);
        
        sc.close();
    }
}
