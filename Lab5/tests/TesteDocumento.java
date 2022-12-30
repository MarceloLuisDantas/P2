package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import documin.Documento;
import documin.Elementos.Atalho;
import documin.Elementos.Elemento;
import documin.Elementos.Texto;

public class TesteDocumento {
    @Test
    public void teste_1() {
        Documento d = new Documento("Teste");
        assertArrayEquals(new Elemento[0], d.getElementos());
        assertArrayEquals(new String[0], d.ShowElementos());
        assertEquals(0, d.mediaPrioridades());
        assertEquals(true, d.cabe());
        assertEquals(false, d.existeElemento(3));
        assertEquals(false, d.temAtalho());
        assertEquals(false, d.isAtalho());
        d.turnAtalho();
        assertEquals(true, d.isAtalho());
    }

    @Test
    public void teste_2() {
        Documento d = new Documento("documento");
        Texto t = new Texto("Teste", 1);
        Texto t2 = new Texto("Teste2", 5);
        assertEquals(1, d.newElemento(t));
        assertEquals(2, d.newElemento(t2));

        assertEquals(t, d.getElemento(1));
        assertEquals(t2, d.getElemento(2));

        Elemento[] result = new Elemento[2];
        result[0] = t;
        result[1] = t2;
        assertArrayEquals(result, d.getElementos());

        assertEquals(3, d.mediaPrioridades());

        Documento a = new Documento("atalho");
        Atalho at = new Atalho("Atalho", 3, a);
        d.newElemento(at);
        assertEquals(true, d.temAtalho());
    }
    
}
