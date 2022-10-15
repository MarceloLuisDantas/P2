import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String[] entrada = input.nextLine().split(" ");
            if (entrada[0].equals("wally")) {
                break;
            }

            String nome = "?";
            for (String valor : entrada) {
                if (valor.length() == 5) {
                    nome = valor;
                }
            }
            
            System.out.println(nome);
        }
        input.close();
    }
}