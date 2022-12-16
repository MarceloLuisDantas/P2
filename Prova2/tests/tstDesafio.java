package tests;

import org.junit.*;
import static org.junit.Assert.*;

import desafios.Desafio;

public class tstDesafio {
    @Test
    public void testeNovoDesafio() {
        Desafio d1 = new Desafio("foo", "bar");
        assertEquals("foo", d1.getTitulo());
        assertEquals("bar", d1.getDescricao());
        assertEquals(0, d1.getExecucao());
        String esperado = "Titulo: foo\n0 Execuções";
        assertEquals(esperado, d1.toString());
    }

    @Test
    public void testeAddExecucao() {
        Desafio d1 = new Desafio("foo", "bar");
        assertEquals(0, d1.getExecucao());
        d1.addExecucao();
        assertEquals(1, d1.getExecucao());
        String esperado = "Titulo: foo\n1 Execuções";
        assertEquals(esperado, d1.toString());
    }
}
