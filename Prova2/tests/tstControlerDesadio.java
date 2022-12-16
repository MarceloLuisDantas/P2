package tests;

import org.junit.*;
import static org.junit.Assert.*;

import desafios.ControlerDesafio;
import desafios.Desafio;

public class tstControlerDesadio {
    @Test
    public void testeAddDesafio() {
        ControlerDesafio cd = new ControlerDesafio();
        String[] input1 = {"ADD_DESAFIO", "30 dias sem açúcar", ""};
        boolean r1 = cd.add_desafio(input1);
        assertEquals(true, r1);
        
        boolean r2 = cd.add_desafio(input1);
        assertEquals(false, r2);

        Desafio d1 = new Desafio(input1[1], input1[2]);
        assertEquals(d1.toString(), cd.exibi_desafio(0));
    }

    @Test
    public void testeAddExecucao() {
        ControlerDesafio cd = new ControlerDesafio();
        String[] input1 = {"ADD_DESAFIO", "30 dias sem açúcar", ""};
        cd.add_desafio(input1);
        assertEquals(0, cd.getDesafio(0).getExecucao());
        cd.add_execucao(0);
        assertEquals(1, cd.getDesafio(0).getExecucao());
    }

    @Test
    public void testeDesafioNaoExistente() {
        ControlerDesafio cd = new ControlerDesafio();
        boolean r = cd.existeDesafio(3);
        assertEquals(false, r);

        cd.add_desafio(new String[]{"", "teste", ""});
        boolean r2 = cd.existeDesafio(1);
        assertEquals(true, r2);
    }
}
