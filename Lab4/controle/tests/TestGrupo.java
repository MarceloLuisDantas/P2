package controle.tests;

import org.junit.*;

import controle.src.Aluno;
import controle.src.Grupo;

import static org.junit.Assert.*;
 
public class TestGrupo {
    @Test
    public void testAdicionarAlunos() {
        Grupo scarlet = new Grupo("Familia Scarlet", 2);
        Aluno remilia = new Aluno("1", "Magia", "Remilia Scarlet");
        Aluno flandre = new Aluno("2", "Magia", "Flander Scalet");

        assertEquals(true, scarlet.addAluno(remilia.getMatricula())); 
        assertEquals(false, scarlet.cheio());
        
        assertEquals(true, scarlet.addAluno(flandre.getMatricula())); 
        assertEquals(true, scarlet.cheio());
        
        assertArrayEquals(new String[]{"1", "2"}, scarlet.getAlunos());
        assertEquals(false, scarlet.addAluno(flandre.getMatricula())); 
        assertArrayEquals(new String[]{"1", "2"}, scarlet.getAlunos());

        Aluno reimu = new Aluno("3", "Sarcedotisa", "Reimua Hakurei");
        
        assertEquals(false, scarlet.addAluno(reimu.getMatricula())); 
        assertArrayEquals(new String[]{"1", "2"}, scarlet.getAlunos());     
    }

    @Test
    public void testEquals() {
        Grupo hakurei = new Grupo("Templo Hakurei", 1);
        Grupo moriya = new Grupo("Templo Moriya", 3);
        assertEquals(false, hakurei.equals(moriya));

        Grupo hakureiPosTH5 = new Grupo("Templo Hakurei", 2);
        assertEquals(true, hakurei.equals(hakureiPosTH5));
    }
}