package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import documin.Elementos.Texto;

public class TesteTexto {
    @Test
    public void teste_1() {
        Texto t = new Texto("foo", 10);
        assertEquals("foo", t.getValor());
        assertEquals(5, t.getPrioridade());

        Texto t2 = new Texto("bar", 3);
        assertEquals(3, t2.getPrioridade());
        assertEquals("bar", t2.representacaoCompleta());
        assertEquals("bar", t2.representacaoResumida());
    }
}
