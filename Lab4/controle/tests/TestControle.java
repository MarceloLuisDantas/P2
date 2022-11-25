package controle.tests;

import org.junit.*;

import controle.src.Controle;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class TestControle {
    @Test
    public void testAddAluno() {
        Controle c = new Controle();
        assertEquals(true, 
            c.addAluno("1", "magia", "marisa"));
        assertEquals(true, 
            c.addAluno("2", "teologia", "Reimu"));
        assertEquals(false, 
            c.addAluno("2", "teologia", "Sanae"));
    }

    @Test
    public void testAddGrupo() {
        Controle c = new Controle();
        assertEquals(true, c.addGrupo("Templo Hakurei", 2));
        assertEquals(true, c.addGrupo("Templo Moriya", 3));
        assertEquals(false, c.addGrupo("Templo Hakurei", 3));
    }

    @Test
    public void testAddAlunoToGrupo() {
        Controle c = new Controle();
        c.addGrupo("Templo Hakurei", 2);
        c.addGrupo("Casa da Alice", 1);
        c.addAluno("1", "magia", "Marisa");
        c.addAluno("2", "teologia", "Reimu");
        c.addAluno("3", "artesanato", "Alice");

        assertEquals("Aluno cadastrado com sucesso", 
            c.addAlunoToGrupo("2", "Templo Hakurei"));
        assertEquals("Aluno cadastrado com sucesso", 
            c.addAlunoToGrupo("3", "casa da alice"));
        assertEquals("A matricula do Aluno não foi encontrada", 
            c.addAlunoToGrupo("4", "Templo Hakurei"));
        assertEquals("O Grupo não foi encontrado", 
            c.addAlunoToGrupo("2", "Templo Moriya"));
        assertEquals("O Grupo esta cheio", 
            c.addAlunoToGrupo("1", "Casa da Alice"));
        assertEquals("O Aluno já esta cadastrado", 
            c.addAlunoToGrupo("2", "Templo Hakurei"));    
    }

    @Test
    public void testConsultaAluno() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");

        assertEquals("Aluno não cadastrado", c.consultaAluno("0"));        
        assertEquals("1 - Marisa - Magia", c.consultaAluno("1"));        
    }

    @Test
    public void testConsultaAlunoGrupos() {
        Controle c = new Controle();
        c.addGrupo("Floresta da Magia", 1);
        c.addGrupo("Templo Hakurei", 2);
        c.addAluno("1", "magia", "Marisa");
        c.addAluno("2", "teologia", "Reimu");
        c.addAlunoToGrupo("1", "Floresta da Magia");
        c.addAlunoToGrupo("2", "Templo Hakurei");
        
        String[] esperado = new String[]{ "Floresta Da Magia 1/1",};
        assertArrayEquals(esperado, c.consultaAlunoGrupos("1"));

        String[] esperado2 = new String[]{"Templo Hakurei 1/2",};
        assertArrayEquals(esperado2, c.consultaAlunoGrupos("2"));

        c.addAlunoToGrupo("1", "Templo Hakurei");
        String[] esperado3 = new String[]{"Floresta Da Magia 1/1", "Templo Hakurei 2/2"};
        assertArrayEquals(esperado3, c.consultaAlunoGrupos("1"));

        String[] esperado4 = new String[]{"Templo Hakurei 2/2",};
        assertArrayEquals(esperado4, c.consultaAlunoGrupos("2"));

        String[] naoCadastrado = new String[]{"Aluno não cadastrado"};
        assertArrayEquals(naoCadastrado, c.consultaAlunoGrupos("3"));
    }

    @Test 
    public void testConsultaGrupoAlunos() {
        Controle c = new Controle();
        c.addGrupo("Montanha Youkai", 1000);
        assertArrayEquals(new String[]{}, c.consultaGrupoAlunos("Montanha Youkai"));

        c.addAluno("1", "Jornalista", "Aya");
        c.addAluno("2", "Segurança", "Momiji");
        c.addAluno("3", "Deusa", "Suwako");
        c.addAlunoToGrupo("1", "Montanha Youkai");
        c.addAlunoToGrupo("2", "Montanha Youkai");
        
        String[] naoCadastrado = new String[]{"Grupo não cadastrado"};
        assertArrayEquals(naoCadastrado, c.consultaGrupoAlunos("Lua"));

        String[] esperado = new String[]{
            "1 - Aya - Jornalista",
            "2 - Momiji - Segurança"
        };
        assertArrayEquals(esperado, c.consultaGrupoAlunos("Montanha Youkai"));

        c.addAlunoToGrupo("3", "Montanha Youkai");
        String[] esperado2 = new String[]{
            "1 - Aya - Jornalista",
            "2 - Momiji - Segurança",
            "3 - Suwako - Deusa"
        };
        assertArrayEquals(esperado2, c.consultaGrupoAlunos("Montanha Youkai"));
    }

    @Test
    public void testListaAlunos() {
        Controle c = new Controle();
        assertArrayEquals(new String[]{}, c.listaAlunos());

        c.addAluno("1", "Empregada", "Sakuya");
        c.addAluno("2", "Porteira", "Hong");
        c.addAluno("3", "Bibliotecaria", "Patchouli");

        String[] esperado = new String[]{
            "1 - Sakuya - Empregada",
            "2 - Hong - Porteira",
            "3 - Patchouli - Bibliotecaria"
        };
        assertArrayEquals(esperado, c.listaAlunos());

        c.addAluno("4", "Ladra", "Marisa");
        String[] esperado2 = new String[]{
            "1 - Sakuya - Empregada",
            "2 - Hong - Porteira",
            "3 - Patchouli - Bibliotecaria",
            "4 - Marisa - Ladra"
        };
        assertArrayEquals(esperado2, c.listaAlunos());
    }

    @Test
    public void testAddAlunoToRespodneram() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");
        assertEquals("Aluno registrado", 
            c.addAlunoToRespodneram("1"));
        assertEquals("Aluno não cadastrado", 
            c.addAlunoToRespodneram("2"));
    }

    @Test
    public void testListaAlunosResponderam() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");

        c.addAlunoToRespodneram("1");
        String[] esperado = new String[]{"1 - Marisa - Magia"};
        assertArrayEquals(esperado, c.listaAlunosResponderam());

        c.addAlunoToRespodneram("2");
        String[] esperado2 = new String[]{
            "1 - Marisa - Magia",
            "2 - Reimu - Teologia"
        };
        assertArrayEquals(esperado2, c.listaAlunosResponderam());

        c.addAlunoToRespodneram("1");
        String[] esperado3 = new String[]{
            "1 - Marisa - Magia",
            "2 - Reimu - Teologia",
            "1 - Marisa - Magia"
        };
        assertArrayEquals(esperado3, c.listaAlunosResponderam());

        c.addAlunoToRespodneram("3");
        String[] esperado4 = new String[]{
            "1 - Marisa - Magia",
            "2 - Reimu - Teologia",
            "1 - Marisa - Magia",
            "3 - Cirno - Math"
        };
        assertArrayEquals(esperado4, c.listaAlunosResponderam());
    }

    @Test
    public void testMaiorQuantidadeDeGrupos() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");
        c.addGrupo("Templo Hakurei", 3);
        c.addGrupo("Floresta da Magia", 2);
        c.addGrupo("Mansão Scarlet", 7);
    
        c.addAlunoToGrupo("1", "Templo Hakurei");
        c.addAlunoToGrupo("2", "Templo Hakurei");
        c.addAlunoToGrupo("3", "Templo Hakurei");
        assertEquals(1, c.maiorQuantidadeDeGrupos());

        c.addAlunoToGrupo("1", "Floresta da Magia");
        c.addAlunoToGrupo("3", "Floresta da Magia");
        assertEquals(2, c.maiorQuantidadeDeGrupos());

        c.addAlunoToGrupo("1", "Mansão Scarlet");
        assertEquals(3, c.maiorQuantidadeDeGrupos());
    }

    @Test
    public void testAlunosEmMaisGrupos() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");
        c.addGrupo("Templo Hakurei", 3);
        c.addGrupo("Floresta da Magia", 2);
        c.addGrupo("Mansão Scarlet", 7);
    
        String[] nemUmCadastrado = new String[]{"Nem um aluno cadastrado em nem um grupo"};
        assertArrayEquals(nemUmCadastrado, c.alunosEmMaisGrupos());

        c.addAlunoToGrupo("1", "Templo Hakurei");
        c.addAlunoToGrupo("2", "Templo Hakurei");
        c.addAlunoToGrupo("3", "Templo Hakurei");
        String[] esperado = new String[] {
            "1 - Marisa - Magia",
            "2 - Reimu - Teologia",
            "3 - Cirno - Math"
        };
        assertArrayEquals(esperado, c.alunosEmMaisGrupos());

        c.addAlunoToGrupo("1", "Floresta da Magia");
        c.addAlunoToGrupo("3", "Floresta da Magia");
        String[] esperado2 = new String[] {
            "1 - Marisa - Magia",
            "3 - Cirno - Math"
        };
        assertArrayEquals(esperado2, c.alunosEmMaisGrupos());

        c.addAlunoToGrupo("1", "Mansão Scarlet");
        String[] esperado3 = new String[] {"1 - Marisa - Magia",};
        assertArrayEquals(esperado3, c.alunosEmMaisGrupos());
    }

    @Test
    public void testGetCursos() {
        Controle c = new Controle();
        
        List<String> esperado = new ArrayList<String>();
        assertEquals(esperado, c.getCursos());

        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");

        List<String> esperado2 = Arrays
            .asList(new String[]{"Magia", "Teologia", "Math"});
        assertEquals(esperado2, c.getCursos());
    }

    @Test
    public void testGetCursoQuantidade() {
        Controle c = new Controle();

        Map<String, Integer> esperado = new HashMap<String, Integer>();
        assertEquals(esperado, c.getCursoQuantidade());

        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");

        Map<String, Integer> esperado2 = new HashMap<String, Integer>();
        esperado2.put("Magia", 1);
        esperado2.put("Teologia", 1);
        esperado2.put("Math", 1);
        assertEquals(esperado2, c.getCursoQuantidade());

        c.addAluno("4", "Magia", "Patchouli");
        c.addAluno("5", "Magia", "Hijiri");
        c.addAluno("6", "Teologia", "Sanae");

        Map<String, Integer> esperado3 = new HashMap<String, Integer>();
        esperado3.put("Magia", 3);
        esperado3.put("Teologia", 2);
        esperado3.put("Math", 1);
        assertEquals(esperado3, c.getCursoQuantidade());
    }

    @Test
    public void testCursos() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");
        c.addAluno("4", "Magia", "Patchouli");
        c.addAluno("5", "Magia", "Hijiri");
        c.addAluno("6", "Teologia", "Sanae");

        String[] esperado = new String[]{
            "Magia : 3 Aluno(s)",
            "Teologia : 2 Aluno(s)",
            "Math : 1 Aluno(s)"
        };
        assertArrayEquals(esperado, c.cursos());
    }

    @Test 
    public void testAlunosSemGrupos() {
        Controle c = new Controle();
        c.addAluno("1", "Magia", "Marisa");
        c.addAluno("2", "Teologia", "Reimu");
        c.addAluno("3", "Math", "Cirno");
        c.addAluno("4", "Magia", "Patchouli");
        
        String[] todos = new String[]{
            "1 - Marisa - Magia",
            "2 - Reimu - Teologia",
            "3 - Cirno - Math",
            "4 - Patchouli - Magia"
        };
        assertArrayEquals(todos , c.alunosSemGrupos());

        c.addGrupo("Templo Hakurei", 2);
        c.addAlunoToGrupo("1", "Templo Hakurei");
        c.addAlunoToGrupo("2", "Templo Hakurei");

        String[] esperado = new String[]{
            "3 - Cirno - Math",
            "4 - Patchouli - Magia"
        };
        assertArrayEquals(esperado, c.alunosSemGrupos());
    }
}