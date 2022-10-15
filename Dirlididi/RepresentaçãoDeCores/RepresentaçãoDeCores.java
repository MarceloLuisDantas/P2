/**
 * Laboratorio Programação 2 - Lab 1
 *
 * @Author Marcelo Dantas - 121210721
 */

import java.util.Scanner;

public class RepresentaçãoDeCores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int g = input.nextInt();
        int b = input.nextInt();
        
        if (r < 128 || g < 128 || b < 128) 
            System.out.println("PRETO");
        else
            System.out.println("BRANCO");

        input.close();
    }
}
