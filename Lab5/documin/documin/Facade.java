package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import documin.Elementos.Atalho;
import documin.Elementos.Elemento;
import documin.Elementos.Lista;
import documin.Elementos.Termo;
import documin.Elementos.Texto;
import documin.Elementos.Titulo;

public class Facade {
    private Map<String, Documento> documentos = new HashMap<String, Documento>();
    private List<String[]> visualizacoes = new ArrayList<String[]>();

    public boolean criarDocumento(String titulo) {
        if (documentos.containsKey(titulo))
            return false;
        
        Documento doc = new Documento(titulo);
        documentos.put(titulo, doc);
        return true;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if (documentos.containsKey(titulo))
            return false;
        
        Documento doc = new Documento(titulo, tamanhoMaximo);
        documentos.put(titulo, doc);
        return true;
    }

    public void removerDocumento(String titulo) {
        if (documentos.containsKey(titulo))
            documentos.remove(titulo);
    }

    public int contarElementos(String titulo) {
        if (documentos.containsKey(titulo)) 
            return documentos.get(titulo).getElementos().length;

        System.out.println("Documento não encontrado");
        return -1;
    }

    public String[] exibirDocumento(String titulo) {
        if (documentos.containsKey(titulo)) 
            return documentos.get(titulo).ShowElementos();

        System.out.println("Documento não encontrado");
        return new String[0];
    }

    private int addElemento(String tituloDoc, Elemento e) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return 0;
        }
        
        if (!documentos.get(tituloDoc).cabe()) {
            System.out.println("Sem espaços disponiveis");
            return 0;
        } 

        System.out.println("Elemento adicionado com sucesso");
        return documentos.get(tituloDoc).newElemento(e);
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

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return 0;
        }

        Documento receberAtalho = documentos.get(tituloDoc);
        if (receberAtalho.isAtalho()) {
            System.out.println("Documentos que são atalhos não podem ter atalhos");    
            return 0;
        }

        if (!documentos.containsKey(tituloDocReferenciado)) {
            System.out.println("Documento " + tituloDocReferenciado + " não encontrado");
            return 0;
        }

        Documento paraAtalho = documentos.get(tituloDocReferenciado);
        if (paraAtalho.temAtalho()) {
            System.out.println("Documentos que possuem atalhos não podem ser atalho");
            return 0;
        }

        documentos.get(tituloDocReferenciado).turnAtalho();
        int prioridade = receberAtalho.mediaPrioridades();
        String valor = paraAtalho.getTitulo();
        Atalho atalho = new Atalho(valor, prioridade, paraAtalho);
        return documentos.get(tituloDoc).newElemento(atalho);
    }

    public String pegarRepresentacaoCompletaDeElemento(String tituloDoc, int elementoPosicao) {
        if (documentos.containsKey(tituloDoc)) {
            return documentos.get(tituloDoc).getElemento(elementoPosicao).representacaoCompleta();
        }
        return "Documento " + tituloDoc + " não encontrado";
    }

    public String pegarrepresentacaoResumidaDeElemento(String tituloDoc, int elementoPosicao) {
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

    public int criarVisaoCompleta(String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        visualizacoes.add(documentos.get(tituloDoc).ShowElementos());
        
        return visualizacoes.size();
    }

    public int criarVisaoResumida(String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        List<Elemento> elementos = Arrays.asList(documentos.get(tituloDoc).getElementos());
        visualizacoes.add(elementos.stream()
            .map((Elemento e) -> e.representacaoResumida())
            .collect(Collectors.toList())
            .toArray(new String[elementos.size()]));
        
        return visualizacoes.size();
    }
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        List<Elemento> elementos = Arrays.asList(documentos.get(tituloDoc).getElementos());
        elementos = elementos.stream()
            .filter((Elemento e) -> e.getPrioridade() >= prioridade)
            .collect(Collectors.toList());

        visualizacoes.add(elementos.stream()
            .map((Elemento e) -> e.representacaoCompleta())
            .collect(Collectors.toList())
            .toArray(new String[elementos.size()]));
        
        return visualizacoes.size();
    }
   
    public int criarVisaoTitulo(String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            System.out.println("Documento " + tituloDoc + " não encontrado");
            return -1;
        }
        List<Elemento> elementos = Arrays.asList(documentos.get(tituloDoc).getElementos());
        elementos = elementos.stream()
            .filter((Elemento e) -> e.getTipo().equals("Titulo"))
            .collect(Collectors.toList());

        visualizacoes.add(elementos.stream()
            .map((Elemento e) -> e.representacaoCompleta())
            .collect(Collectors.toList())
            .toArray(new String[elementos.size()]));
            
        return visualizacoes.size();
    }
   
    public String[] exibirVisao(int visaoId) {
        if (visaoId > visualizacoes.size()) 
            return new String[0];
        return visualizacoes.get(visaoId - 1);
    }

}
