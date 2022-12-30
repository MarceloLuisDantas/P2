package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import documin.Facade;

public class TesteFacade {
    @Test
    public void teste_1() {
        Facade f = new Facade();

        assertEquals(true, f.criarDocumento("doc1", 3));
        assertEquals(false, f.criarDocumento("doc1"));

        assertEquals(1, f.criarTexto("doc1", "teste1", 3));
        assertEquals(2, f.criarTexto("doc1", "teste2", 4));
        
        f.criarDocumento("Doc2");
        assertEquals(3, f.criarAtalho("doc1", "Doc2"));
        assertEquals(-3, f.criarAtalho("doc1", "Doc3"));

        assertEquals(-2, f.criarTexto("doc1", "teste3", 3));
        assertEquals(-1, f.criarTexto("doc3", "teste3", 3));

        assertEquals(1, f.criarVisaoCompleta("doc1"));
        assertEquals(2, f.criarVisaoResumida("doc1"));
        assertEquals(3, f.criarVisaoPrioritaria("doc1", 3));
        assertEquals(4, f.criarVisaoPrioritaria("doc1", 4));

        String[] result = new String[3];
        result[0] = "teste1";
        result[1] = "teste2";
        result[2] = "";
        assertArrayEquals(result, f.exibirVisao(1));
        assertArrayEquals(result, f.exibirVisao(2));
        
        String[] result2 = new String[3];
        result2[0] = "teste1";
        result2[1] = "teste2";
        result2[2] = "";
        assertArrayEquals(result2, f.exibirVisao(3));

        String[] result3 = new String[1];
        result3[0] = "teste2";
        assertArrayEquals(result3, f.exibirVisao(4));
    }
}
