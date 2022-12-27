package documin;

import java.util.HashMap;
import java.util.Map;

import documin.Elementos.Elemento;
import documin.Elementos.Lista;
import documin.Elementos.Termo;
import documin.Elementos.Texto;
import documin.Elementos.Titulo;

public class Facade {
    private Map<String, Documento> documentos = new HashMap<String, Documento>();

    private int addElemento(String tituloDoc, Elemento e) {
        if (documentos.containsKey(tituloDoc)) {
            if (documentos.get(tituloDoc).cabe()) {
                System.out.println("Elemento adicionado com sucesso");
                return documentos.get(tituloDoc).newElemento(e);
            } 
            System.out.println("Sem espaços disponiveis");
            return 0;
        }
        System.out.println("Documento " + tituloDoc + " não encontrado");
        return 0;
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Texto texto = new Texto(valor, prioridade);
        return addElemento(tituloDoc, texto);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Titulo titulo = new Titulo(valor, prioridade, nivel, linkavel);
        return addElemento(tituloDoc, titulo);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Lista lista = new Lista(valorLista, prioridade, separador, charLista);
        return addElemento(tituloDoc, lista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        if (prioridade >= 5) { 
            System.out.println("A maior prioridade é 5, ela sera ajustada altomaticamente para 5");
            prioridade = 5;
        }

        Termo termo = new Termo(valorTermos, prioridade, separador, ordem);
        return addElemento(tituloDoc, termo);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) {
            return documentos.get(tituloDoc).getElemento(elementoPosicao).representacaoCompleta();
        }
        return "Documento " + tituloDoc + " não encontrado";
    }

    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) {
            return documentos.get(tituloDoc).getElemento(elementoPosicao).representacaoResumida();
        }
        return "Documento " + tituloDoc + " não encontrado";
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) 
            return (documentos.get(tituloDoc).removeElemento(elementoPosicao) != null);
        return false;
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) {
            documentos.get(tituloDoc).swapUp(elementoPosicao);
        }
    }
    
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) {
            documentos.get(tituloDoc).swapDown(elementoPosicao);
        }
    }
    

}
