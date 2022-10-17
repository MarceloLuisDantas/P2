package tests;

import java.util.Arrays;

import coisarepl.funcs.Resumo;
import coisarepl.funcs.Utils;

public class Testes {
    private static void utilsCheckParenteses() {
        Boolean result1 = Utils.checkParenteses("(asodiuas)".split(" "));
        Test.test("1º Utils Check Parenteses", true, result1);
        
        Boolean result2 = Utils.checkParenteses("tes (asodiuas) \"asd as\"".split(" "));
        Test.test("2º Utils Check Parenteses", true, result2);
        
        Boolean result3 = Utils.checkParenteses("tes (aso diu as)".split(" "));
        Test.test("3º Utils Check Parenteses", true, result3);

        Boolean result4 = Utils.checkParenteses("".split(" "));
        Test.test("4º Utils Check Parenteses", false, result4);
        
        Boolean result5 = Utils.checkParenteses("tes (aso (diu) as)".split(" "));
        Test.test("5º Utils Check Parenteses", false, result5);

        Boolean result6 = Utils.checkParenteses("tes (aso \"diu\" as)".split(" "));
        Test.test("6º Utils Check Parenteses", false, result6);
    }
    private static void utilsCheckAspas() {
        Boolean result1 = Utils.checkAspas("\"asodiuas\"".split(" "));
        Test.test("1º Utils Check Aspas", true, result1);
        
        Boolean result2 = Utils.checkAspas("\"asodi\"uas\"".split(" "));
        Test.test("2º Utils Check Aspas", false, result2);
        
        Boolean result3 = Utils.checkAspas("\"asodiuas".split(" "));
        Test.test("3º Utils Check Aspas", false, result3);
        
        Boolean result4 = Utils.checkAspas("asd (asd asd) \"asd asd\"".split(" "));
        Test.test("4º Utils Check Aspas", true, result4);
        
        Boolean result5 = Utils.checkAspas("asd (asd asd) \"asd ()\"".split(" "));
        Test.test("5º Utils Check Aspas", true, result5);

        Boolean result6 = Utils.checkAspas("asd (asd asd) \"a\"asd".split(" "));
        Test.test("6º Utils Check Aspas", false, result6);  
    }
    private static void utilsClear() {
        String result1 = Utils.clear("asd");
        Test.test("1º Utils Clear", "asd", result1);
        
        String result2 = Utils.clear("(asd");
        Test.test("2º Utils Clear", "asd", result2);
        
        String result3 = Utils.clear("asd)");
        Test.test("3º Utils Clear", "asd", result3);
    }  
    private static void utilsGetIndicesIntervalo() {
        int[] result1 = Utils.getIndicesIntervalo("asd asd \"asd asd fd\"".split(" "));
        Test.test("1º Utils Indice Intervarlo", "[2, 4]", 
            Arrays.toString(result1));

        int[] result2 = Utils.getIndicesIntervalo("asd \"asd asd fd\" asd ".split(" "));
        Test.test("2º Utils Indice Intervarlo", "[1, 3]", 
            Arrays.toString(result2));

        int[] result3 = Utils.getIndicesIntervalo("\"asd asd fd\" asd asd ".split(" "));
        Test.test("3º Utils Indice Intervarlo", "[0, 2]", 
            Arrays.toString(result3));
    }
    public static void testUtils() {
        utilsCheckParenteses();
        System.out.println();
        utilsCheckAspas();
        System.out.println();
        utilsClear();
        System.out.println();
        utilsGetIndicesIntervalo();
        System.out.println();
    }

    private static void resumoGetTags() {
        String[] result1 = Resumo.getTags("asd ajs (asd asd asd asd)".split(" "));
        Test.test("1º Resumo Get Tags", "[asd, asd, asd, asd]", 
            Arrays.toString(result1));
        
        String[] result2 = Resumo.getTags("(asd asd asd asd) asd ajs ".split(" "));
        Test.test("2º Resumo Get Tags", "[asd, asd, asd, asd]", 
            Arrays.toString(result2));
        
        String[] result3 = Resumo.getTags("asd (asd asd asd asd) ajs".split(" "));
        Test.test("3º Resumo Get Tags", "[asd, asd, asd, asd]", 
            Arrays.toString(result3));
    }
    private static void resumoGetResumo() {
        String[] input1 = "asd (asd asd) \"123 123 123\"".split(" ");
        String result1 = Resumo.getResumo(input1);
        Test.test("1º Resumo Get Resumop", "123 123 123", result1);

        String[] input2 = "asd (asd asd) \"123 12 ad 3 123\" asd".split(" ");
        String result2 = Resumo.getResumo(input2);
        Test.test("2º Resumo Get Resumop", "123 12 ad 3 123", result2);

        String[] input3 = "asd (asd asd) \"\" asd".split(" ");
        String result3 = Resumo.getResumo(input3);
        Test.test("3º Resumo Get Resumop", "", result3);

        String[] input4 = "asd (asd asd) \" \" asd".split(" ");
        String result4 = Resumo.getResumo(input4);
        Test.test("4º Resumo Get Resumop", "", result4);
    }
    private static void resumoSintaxeNovo() {
        String[] input1 = "Resumo novo (123, 123) \"numeros legais\"".split(" ");
        Boolean result1 = Resumo.checkSintaxeNovo(input1);
        Test.test("1º Resumo", true, result1);
        
        String[] input2 = "Resumo novo abc (123, 123) \"numeros legais".split(" ");
        Boolean result2 = Resumo.checkSintaxeNovo(input2);
        Test.test("2º Resumo", false, result2);

        String[] input3 = "Resumo novo abc (123, 123 \"numeros legais\"".split(" ");
        Boolean result3 = Resumo.checkSintaxeNovo(input3);
        Test.test("3º Resumo", false, result3);

        String[] input4 = "Resumo novo abc (123, \"123) \"numeros legais\"".split(" ");
        Boolean result4 = Resumo.checkSintaxeNovo(input4);
        Test.test("4º Resumo", false, result4);

        String[] input5 = "Resumo novo abc \"numeros legais\" (123, 123)".split(" ");
        Boolean result5 = Resumo.checkSintaxeNovo(input5);
        Test.test("5º Resumo", false, result5);
    
        String[] input6 = "Resumo novo abc (123, 123) \"numeros ()  legais\"".split(" ");
        Boolean result6 = Resumo.checkSintaxeNovo(input6);
        Test.test("6º Resumo", true, result6);

        String[] input7 = "Resumo novo abc (123, 123) \"numeros \" legais\"".split(" ");
        Boolean result7 = Resumo.checkSintaxeNovo(input7);
        Test.test("7º Resumo", false, result7);
    }
    public static void testResumo() {
        System.out.println("Testes Resumo: ");
        resumoGetTags();
        System.out.println();
        resumoGetResumo();
        System.out.println();
        resumoSintaxeNovo();
        System.out.println();
    }
    
    public static void main(String[] args) {
        testUtils();
        testResumo();
    }
}
