/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class MaiorEMenorDeDuasPalavras {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String p1 = input.nextLine();
        String p2 = input.nextLine();

        if (p1.length() == p2.length()) 
            System.out.println(p1 + "\n" + p1);
        else if (p1.length() > p2.length())
            System.out.println(p2 + "\n" + p1);
        else 
            System.out.println(p1 + "\n" + p2);

        input.close();
    }
}
