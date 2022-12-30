package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import documin.Elementos.Titulo;

public class TesteTitulo {
    @Test
    public void teste_1() {
        Titulo t = new Titulo("Ideia", 3, 1, true);
        String result = 1 + ". " + "Ideia --\n1- IDEIA";
        assertEquals(result, t.representacaoCompleta());

        String result2 = 1 + ". " + "Ideia";
        assertEquals(result2, t.representacaoResumida());

        Titulo t2 = new Titulo("Ideia2", 3, 6, false);
        String result3 = 5 + ". " + "Ideia2";
        assertEquals(result3, t2.representacaoCompleta());        
        assertEquals(result3, t2.representacaoResumida());        
    }
}
