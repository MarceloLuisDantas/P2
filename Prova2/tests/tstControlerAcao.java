package tests;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

import desafios.Acao;
import desafios.ControlerAcao;

public class tstControlerAcao {
    @Test
    public void testeAddAcao() {
        ControlerAcao ca = new ControlerAcao();
        String[] input1 = "ADD_ACAO 1 “14/12/2022” 44".split(" ");
        boolean r1 = ca.add_acao(input1);
        assertEquals(true, r1);

        boolean r2 = ca.add_acao(input1);
        assertEquals(false, r2);

        Acao a1 = new Acao(1, "“14/12/2022”", 44);
        Acao a2 = ca.getAcao(44);
        assertEquals(a1.getId(), a2.getId());
        assertEquals(a1.getDesafioId(), a2.getDesafioId());
        assertEquals(a1.getData(), a2.getData());
        assertEquals(a1.toString(), ca.exibi_acao(44));

        String[] input2 = "ADD_ACAO 2 “15/12/2022” 44".split(" ");
        boolean r3 = ca.add_acao(input2);
        assertEquals(false, r3);
    }

    @Test
    public void testeAddProgresso() {
        ControlerAcao ca = new ControlerAcao();
        String[] input1 = "ADD_ACAO 1 “14/12/2022” 42".split(" ");
        ca.add_acao(input1);
        boolean r1 = ca.add_progresso(42, 20);
        assertEquals(false, r1);

        Acao a1 = ca.getAcao(42);
        assertEquals(20, a1.getProgresso());

        ca.add_progresso(42, 0);
        Acao a2 = ca.getAcao(42);
        assertEquals(30, a2.getProgresso());

        boolean r2 = ca.add_progresso(42, 200);
        assertEquals(true, r2);

        Acao a3 = ca.getAcao(42);
        assertEquals(100, a3.getProgresso());       

        assertEquals(true, ca.acao_completa(42));
    }

    @Test
    public void testeAcoesOrdenadas() {
        ControlerAcao ca = new ControlerAcao();
        String[] input1 = "ADD_ACAO 1 foo 1".split(" ");
        String[] input2 = "ADD_ACAO 2 foo 2".split(" ");
        String[] input3 = "ADD_ACAO 3 foo 3".split(" ");
        String[] input4 = "ADD_ACAO 4 foo 4".split(" ");
        ca.add_acao(input1);
        ca.add_acao(input2);
        ca.add_acao(input3);
        ca.add_acao(input4);
        ca.add_progresso(3, 70);
        ca.add_progresso(4, 40);
        ca.add_progresso(1, 40);
        ca.add_progresso(2, 30);
        List<Acao> lista = ca.acoes_ordenadas();
        int id_1 = lista.get(0).getId();
        int id_2 = lista.get(1).getId();
        int id_3 = lista.get(2).getId();
        int id_4 = lista.get(3).getId();
        assertEquals(3, id_1);
        assertEquals(1, id_2);
        assertEquals(4, id_3);
        assertEquals(2, id_4);
    }

    @Test
    public void testeAcoesOrdenadas2() {
        ControlerAcao ca = new ControlerAcao();
        String[] input1 = "ADD_ACAO 1 foo 1".split(" ");
        String[] input2 = "ADD_ACAO 2 foo 2".split(" ");
        String[] input3 = "ADD_ACAO 3 foo 3".split(" ");
        String[] input4 = "ADD_ACAO 4 foo 4".split(" ");
        ca.add_acao(input1);
        ca.add_acao(input2);
        ca.add_acao(input3);
        ca.add_acao(input4);
        ca.add_progresso(1, 100);
        ca.add_progresso(2, 100);
        ca.add_progresso(3, 90);
        ca.add_progresso(4, 100);
        List<Acao> lista = ca.acoes_ordenadas();
        int id_1 = lista.get(0).getId();
        int id_2 = lista.get(1).getId();
        int id_3 = lista.get(2).getId();
        int id_4 = lista.get(3).getId();
        assertEquals(1, id_1);
        assertEquals(2, id_2);
        assertEquals(4, id_3);
        assertEquals(3, id_4);
    }
}
