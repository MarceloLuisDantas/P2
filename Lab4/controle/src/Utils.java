package controle.src;

import java.util.Scanner;

public class Utils {
    private static Scanner input = new Scanner(System.in);

    public static String input(String label) {
        while (true) {
            System.out.print(label);
            String entrada = new String();
            entrada = input.nextLine();
            if (entrada.equals(""))
                System.out.println("Nada não é uma entrada valida");
            else 
                return entrada.toLowerCase();
        }
    }
    
    public static int inputInt(String label) {
        while (true) {
            System.out.print(label);
            int valor = 0;
            try {
                valor = input.nextInt();
                input.nextLine();
                return valor;
            } catch (NumberFormatException x) {
                System.out.println("Entrada invalida, tente novamente. ");
            } 
        }
    }

    public static String capitalize(String linha) {
        String[] palavras = linha.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i != palavras.length; i++)
            stringBuilder.append(Character.toUpperCase(
                palavras[i].charAt(0)) + palavras[i].substring(1) + " ");
        return stringBuilder.toString().trim();
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
