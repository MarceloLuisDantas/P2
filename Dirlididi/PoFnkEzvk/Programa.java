import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Programa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        String[] entrada = input.nextLine().split(" ");
        for (String valor : entrada) {
            numeros.add(Integer.valueOf(valor));
        }
       
        int media = numeros.stream().reduce(0, Integer::sum) / numeros.size();
        List<Integer> maiores = numeros
            .stream()
            .filter(a -> a > media)
            .collect(Collectors.toList());

        for (Integer valor : maiores) {
            System.out.print(valor + " ");
        }
        
        input.close();
    }
}
