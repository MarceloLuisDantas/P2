package tests;

import org.junit.*;
import static org.junit.Assert.*;

import desafios.Acao;
import desafios.Controler;
import desafios.Desafio;

public class tstControler {
    @Test
    public void testeAddDesafio() {
        Controler c = new Controler();
        String[] input1 = {"ADD_DESAFIO", "30 dias sem açúcar", ""};
        boolean r1 = c.add_desafio(input1);
        assertEquals(true, r1);
        
        boolean r2 = c.add_desafio(input1);
        assertEquals(false, r2);

        Desafio d1 = new Desafio(input1[1], input1[2]);
        assertEquals(d1.toString(), c.show_desafio(0));
    }

    @Test
    public void testeAddAcao() {
        Controler c = new Controler();
        String[] input1 = "ADD_ACAO 1 “14/12/2022” 44".split(" ");
        boolean r1 = c.add_acao(input1);
        assertEquals(true, r1);

        boolean r2 = c.add_acao(input1);
        assertEquals(false, r2);

        Acao a1 = new Acao(1, "“14/12/2022”", 44);
        assertEquals(a1.toString(), c.show_acao(44));
    }

    @Test
    public void testeProgressoAcao() {
        Controler c = new Controler();
        String[] inputDesafio = {"ADD_DESAFIO", "30 dias sem açúcar", ""};
        String[] inputAcao = "ADD_ACAO 1 “14/12/2022” 44".split(" ");
        c.add_desafio(inputDesafio);
        c.add_acao(inputAcao);
        
        String r1 = c.progresso_acao(44, 0);
        assertEquals(r1, "Progresso realizado");
        
        String r2 = c.progresso_acao(44, 100);
        assertEquals(r2, "Acão completada com sucesso");
        
        String r3 = c.progresso_acao(44, 100);
        assertEquals(r3, "Ações já compeltadas não podem ser alteradas");
    }
}
