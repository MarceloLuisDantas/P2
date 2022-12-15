package documin;

import java.util.ArrayList;
import java.util.List;

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

    public boolean newElemento(Elemento e) {
        if (!(tamanho == 0)) 
            if (elementos.size() == tamanho) 
                return false;

        elementos.add(e);
        return true;
    }
    
    public String[] ShowElementos() {
        List<String> resultado = new ArrayList<String>();
        for (Elemento e : elementos) 
            resultado.add(e.representacaoCompleta());

        return resultado.toArray(new String[tamanho]);
    }
}
