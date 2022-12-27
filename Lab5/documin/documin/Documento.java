package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import documin.Elementos.Elemento;

public class Documento {
    private List<Elemento> elementos = new ArrayList<Elemento>();
    private int tamanho = 0; 
    private String titulo;

    public Documento(String titulo) {
        this.titulo = titulo;
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
    }

    public boolean cabe() {
        if (tamanho == 0) 
            return true;
        return (elementos.size() < tamanho);
    }

    public int newElemento(Elemento e) {
        elementos.add(e);
        return elementos.size();
    }

    public Elemento removeElemento(int indice) {
        return elementos.remove(indice);
    }

    public Elemento getElemento(int indice) {
        return elementos.get(indice);
    }

    public String[] ShowElementos() {
        List<String> resultado = new ArrayList<String>();
        for (Elemento e : elementos) 
            resultado.add(e.representacaoCompleta());

        return resultado.toArray(new String[tamanho]);
    }

    public void swapUp(int indice) {
        if (indice < elementos.size() - 1) 
            Collections.swap(elementos, indice, indice + 1);
    }
    
    public void swapDown(int indice) {
        if (indice > 0) 
            Collections.swap(elementos, indice, indice - 1);
    }
}
