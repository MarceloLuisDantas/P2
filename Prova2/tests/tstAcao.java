package tests;

import org.junit.*;
import static org.junit.Assert.*;

import desafios.Acao;

public class tstAcao {
    @Test
    public void testeNovaAcao() {
        Acao a1 = new Acao(1, "hoje", 2);
        assertEquals(1, a1.getDesafioId());
        assertEquals("hoje", a1.getData());
        assertEquals(0, a1.getProgresso());
        int id = a1.getId();
        assertEquals(2, id);
        String esperado = "Acao 2 0/100";
        assertEquals(esperado, a1.toString());
    }

    @Test
    public void testeAddProgresso() {
        Acao a1 = new Acao(1, "hoje", 2);
        assertEquals(0, a1.getProgresso());
        boolean r1 = a1.add_progresso(0);
        assertEquals(10, a1.getProgresso());
        assertEquals(false, r1);
        boolean r2 = a1.add_progresso(30);
        assertEquals(40, a1.getProgresso());
        assertEquals(false, r2);
        boolean r3 = a1.add_progresso(70);
        assertEquals(100, a1.getProgresso());
        assertEquals(true, r3);
        boolean r4 = a1.add_progresso(70);
        assertEquals(100, a1.getProgresso());
        assertEquals(true, r4);
    }

    @Test
    public void testeToString() {
        Acao a1 = new Acao(1, "hoje", 2);
        String esperado = "Acao 2 0/100";
        assertEquals(esperado, a1.toString());
        a1.add_progresso(90);
        String esperado2 = "Acao 2 90/100";
        assertEquals(esperado2, a1.toString());
        a1.add_progresso(90);
        String esperado3 = "Acao 2 100/100";
        assertEquals(esperado3, a1.toString());
    }
}
