/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class MaiorEMenor {
    static int maior(int p1, int p2) {
        return (p1 >= p2) ? p1 : p2;
    }
    static int menor(int p1, int p2) {
        return (p1<= p2) ? p1 : p2;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    
        int p1 = sc.nextInt();            
        int maior = p1;
        int menor = p1;
        
        int p2 = sc.nextInt();        
        maior = maior(maior, p2);
        menor = menor(menor, p2);
        
        int p3 = sc.nextInt();        
        maior = maior(maior, p3);
        menor = menor(menor, p3);
        
        int p4 = sc.nextInt();        
        maior = maior(maior, p4);
        menor = menor(menor, p4);
        
        int p5 = sc.nextInt();        
        maior = maior(maior, p5);
        menor = menor(menor, p5);
        
        System.out.println((maior - menor));

        sc.close();
    }
}
