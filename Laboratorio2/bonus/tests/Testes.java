package tests;

import java.util.Arrays;

import coisarepl.funcs.Resumo;

public class Testes {
    private static void resumoCheckParenteses() {
        Boolean result1 = Resumo.checkParenteses("(asodiuas)".split(" "));
        Test.test("1º Resumo Check Parenteses", true, result1);
        
        Boolean result2 = Resumo.checkParenteses("tes (asodiuas) \"asd as\"".split(" "));
        Test.test("2º Resumo Check Parenteses", true, result2);
        
        Boolean result3 = Resumo.checkParenteses("tes (aso diu as)".split(" "));
        Test.test("3º Resumo Check Parenteses", true, result3);
        
        Boolean result4 = Resumo.checkParenteses("tes (aso diu) as)".split(" "));
        Test.test("4º Resumo Check Parenteses", false, result4);

        Boolean result5 = Resumo.checkParenteses("tes (aso (diu) as)".split(" "));
        Test.test("5º Resumo Check Parenteses", false, result5);

        Boolean result6 = Resumo.checkParenteses("tes (aso \"diu\" as)".split(" "));
        Test.test("6º Resumo Check Parenteses", false, result6);

        Boolean result7 = Resumo.checkParenteses("".split(" "));
        Test.test("7º Resumo Check Parenteses", false, result7);
    }
    private static void resumoCheckAspas() {
        Boolean result1 = Resumo.checkAspas("\"asodiuas\"".split(" "));
        Test.test("1º Resumo Check Aspas", true, result1);
        
        Boolean result2 = Resumo.checkAspas("tes (asodiuas) \"asd as\"".split(" "));
        Test.test("2º Resumo Check Aspas", true, result2);
        
        Boolean result3 = Resumo.checkAspas("tes (aso diu as)".split(" "));
        Test.test("3º Resumo Check Aspas", false, result3);
        
        Boolean result4 = Resumo.checkAspas("tes (aso) \"diu) as\"".split(" "));
        Test.test("4º Resumo Check Aspas", false, result4);

        Boolean result5 = Resumo.checkAspas("tes \"teste\" (aso as)".split(" "));
        Test.test("5º Resumo Check Aspas", true, result5);

        Boolean result6 = Resumo.checkAspas("tes (aso \"diu\" as)".split(" "));
        Test.test("6º Resumo Check Aspas", false, result6);

        Boolean result7 = Resumo.checkAspas("".split(" "));
        Test.test("7º Resumo Check Aspas", false, result7);
    }
    private static void resumoClear() {
        String result1 = Resumo.clear("asd");
        Test.test("1º Resumo Clear", "asd", result1);
        
        String result2 = Resumo.clear("(asd");
        Test.test("2º Resumo Clear", "asd", result2);
        
        String result3 = Resumo.clear("asd)");
        Test.test("3º Resumo Clear", "asd", result3);
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
    private static void resumoGetIndicesIntervalo() {
        int[] result1 = Resumo.getIndicesIntervalo("asd asd \"asd asd fd\"".split(" "));
        Test.test("1º Resumo Indice Intervarlo", "[2, 4]", 
            Arrays.toString(result1));

        int[] result2 = Resumo.getIndicesIntervalo("asd \"asd asd fd\" asd ".split(" "));
        Test.test("2º Resumo Indice Intervarlo", "[1, 3]", 
            Arrays.toString(result2));

        int[] result3 = Resumo.getIndicesIntervalo("\"asd asd fd\" asd asd ".split(" "));
        Test.test("3º Resumo Indice Intervarlo", "[0, 2]", 
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
    public static void testResumo() {
        System.out.println("Testes Resumo: ");
        resumoCheckParenteses();
        System.out.println();
        resumoCheckAspas();
        System.out.println();
        resumoClear();
        System.out.println();
        resumoGetTags();
        System.out.println();
        resumoGetIndicesIntervalo();
        System.out.println();
        resumoGetResumo();
        System.out.println();
    }
    
    public static void main(String[] args) {
        testResumo();
    }
}
