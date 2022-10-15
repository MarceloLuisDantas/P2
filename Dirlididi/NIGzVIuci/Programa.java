import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> notas = new ArrayList<Integer>();
        while (true) {
            String entrada = input.nextLine();
            if (entrada.equals("-")) {
                break;
            }

            int nota = Integer.valueOf(entrada.split(" ")[1]);
            notas.add(nota);
        }
        Collections.sort(notas);

        int media = notas.stream().reduce(0, Integer::sum) / notas.size();
        int maior = notas.get(notas.size() - 1);
        int menor = notas.get(0);

        int acima = 0;
        for (int valores : notas) {
            if (valores >= 700) 
                acima += 1;
        }

        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + (notas.size() - acima));

        input.close();
    }
}