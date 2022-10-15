package coisarepl;
import java.util.Scanner;

public class IO {
    private static Scanner input = new Scanner(System.in);

    public static void print(String label)   { System.out.print(label); }
    public static void println(String label) { System.out.println(label); }

    public static String input(String label) { 
        print(label);
        return input.nextLine(); 
    }
    public static String[] input_split(String label) {
        print(label);
        return input.nextLine().split(" ");
    }
}
