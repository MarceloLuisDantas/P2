package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import documin.Elementos.Termo;

public class TesteTermo {
    @Test
    public void teste_1() {
        Termo t = new Termo("1/2/3", 1, "/", "N");
        String result = "Total termos: 3\n - 1, 2, 3";
        assertEquals(result, t.representacaoCompleta());
        assertEquals("1/2/3", t.representacaoResumida());

        Termo t2 = new Termo("c/b/a", 1, "/", "alfabetica");
        String result2 = "Total termos: 3\n - a, b, c";
        assertEquals(result2, t2.representacaoCompleta());

        Termo t3 = new Termo("a/aa/bbb", 1, "/", "alfabetica");
        String result3 = "Total termos: 3\n - a, aa, bbb";
        assertEquals(result3, t3.representacaoCompleta());
    }
}
