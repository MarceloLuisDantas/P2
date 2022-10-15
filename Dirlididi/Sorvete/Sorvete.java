/**
* Laboratorio Programação 2 - Lab 1
*
* @Author Marcelo Dantas - 121210721
*/

import java.util.Scanner;

public class Sorvete {
    static int diff(int v1, int v2) {
        return v1 >= v2 ? v1 - v2 : v2 - v1;
    }
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
        int obj1_pos = input.nextInt();
        int obj1_vel = input.nextInt();
        int obj2_pos = input.nextInt();
        int obj2_vel = input.nextInt();
        int tempo = input.nextInt();

        int distancia_obj1 = obj1_vel * tempo;
        int distancia_obj2 = obj2_vel * tempo;

        obj1_pos += distancia_obj1;
        obj2_pos += distancia_obj2;

        System.out.println(diff(obj1_pos, obj2_pos));
        
        input.close();
    }
}
