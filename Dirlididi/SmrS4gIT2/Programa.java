import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Programa {
    static String get_compra(List<String> linha) {
        linha.remove(0);
        linha.remove(linha.size() - 1);
        return linha.stream().collect(Collectors.joining(" "));
    }
    static Integer get_maior_demora(List<Integer> dias) {
        Integer maior = 0;
        for (dia) 
    }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        List<Integer> dias     = new ArrayList<Integer>();
        List<String>  compras  = new ArrayList<String>(); 
        List<Float>   registro = new ArrayList<Float>();
        registro.add(1200.00);
        dias.add(0);

        while (true) {
            List<String> linha = input.nextLine().split(" ");
            
            Integer dia = Integer.valueOf(linha.get(0));
            dias.add(dia);

            Float sobra = Float.valueOf(linha.get(linha.size() - 1));
            registro.add(sobra);
            
            String compra = get_compra(linha);
            compras.add(compra);

            if (sobra == 0) {
                break;
            }
        }


    }
}