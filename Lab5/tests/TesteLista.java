package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import documin.Elementos.Lista;

public class TesteLista {
    @Test
    public void teste_1() {
        Lista l = new Lista("1/2/3/4", 3, "/", "-");
        String esperado = "- 1\n- 2\n- 3\n- 4\n";
        assertEquals(esperado, l.representacaoCompleta());

        String esperado2 = "1, 2, 3, 4";
        assertEquals(esperado2, l.representacaoResumida());
    }
}
