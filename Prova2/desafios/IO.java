package desafios;

import java.util.Scanner;

public class IO {
    private static Scanner input = new Scanner(System.in);

    public static String input(String label) {
        System.out.print(label);
        return input.nextLine();
    }
}
