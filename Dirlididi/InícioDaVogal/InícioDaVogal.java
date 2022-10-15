/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class InícioDaVogal {
    static Scanner sc = new Scanner(System.in);
    static void inicio_a() {
        String[] palavra = sc.next().split("");
        System.out.println(((palavra[0].equals("a")) ? "s" : "n"));
    }
    public static void main(String[] args) {
        inicio_a();
        inicio_a();
        inicio_a();
        inicio_a();
        inicio_a();
    }
}
