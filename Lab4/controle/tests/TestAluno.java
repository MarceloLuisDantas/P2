package controle.tests;

import org.junit.*;

import controle.src.Aluno;

import static org.junit.Assert.*;
 
public class TestAluno {
    @Test
    public void testBasico() {
        Aluno cirno = new Aluno("9", "Math", "Cirno");
        assertArrayEquals(new String[]{}, cirno.getGrupos());
        assertEquals("Cirno", cirno.getNome());
        assertEquals("Math", cirno.getCurso());
        assertEquals("9", cirno.getMatricula());
    }
    
    @Test
    public void testGrupos() {
        Aluno aluno = new Aluno("1", "Magia", "Marisa Kirisame");
        assertEquals(true, aluno.addGrupo("Mansão Scarlet"));
        assertEquals(true, aluno.addGrupo("Cogumelos"));

        assertEquals(2, aluno.totalGrupos());
        assertArrayEquals(new String[]{"mansão scarlet", "cogumelos"}, aluno.getGrupos());

        assertEquals(false, aluno.addGrupo("Cogumelos"));
        assertEquals(2, aluno.totalGrupos());
        assertArrayEquals(new String[]{"mansão scarlet", "cogumelos"}, aluno.getGrupos());
    } 

    @Test
    public void testEquals() {
        Aluno marisa = new Aluno("1", "Magia", "Marisa Kirisame");
        Aluno reimu = new Aluno("1", "Sacerdotisa", "Reimu Hakurei");
        Aluno sanae = new Aluno("2", "Sarcedotisa", "Sanae Kochiya");

        assertEquals(true, marisa.equals(reimu));
        assertEquals(false, reimu.equals(sanae));
    }

    @Test
    public void testToString() {
        Aluno aya = new Aluno("1", "Jornalista", "Aya Shameimaru");
        assertEquals("1 - Aya Shameimaru - Jornalista", aya.toString());
    }
}