package controle;

import java.util.Scanner;

public class IO {
    private static Scanner input = new Scanner(System.in);

    public static String input(String label) {
        System.out.print(label);
        return input.nextLine();
    }
    
    public static int inputInt(String label) {
        System.out.print(label);
        int valor = input.nextInt();
        input.nextLine();
        return valor;
    }

    public final static void cls() {
        try {
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch(final Exception e) {
            e.printStackTrace();
        }
    }
}
