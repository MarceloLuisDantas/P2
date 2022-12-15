package documin;

import java.util.HashMap;
import java.util.Map;


/**
 * Classe responsavel por gerenciar todos os documentos
 */
public class ControlerDocumentos {    
    private Map<String, Documento> documentos = new HashMap<String, Documento>();
    
    /**
     * Verifica se um nome já esta cadastrado.
     * @param nome Nome do documento
     * @return Se já esta cadastrado
     */
    public boolean nomeExistente(String nome) {
        return documentos.containsKey(nome);
    }

    /**
     * Retorna quantos documentos já foram registrados
     * @return Numero de documentos
     */
    public int totalDocumentosCadastrados() {
        return documentos.size();
    }


    /**
     * Cria um novo documento sem limite na quantidade de elementos
     * @param nome Nome do documento
     */
    public void newDocument(String nome) {
        Documento d = new Documento(nome);
        documentos.put(nome, d);
    }

    /**
     * Cria um documento com um limite na quantidade de elementos
     * @param nome Nome do documento
     * @param tamanho Total de elementos
     */
    public void newDocument(String nome, int tamanho) {
        Documento d = new Documento(nome, tamanho);
        documentos.put(nome, d);
    }

    /**
     * Remove um documento espefico
     * @param nome Nome do documento a ser removido
     */
    public void removeDocument(String nome) {
        documentos.remove(nome); 
    }

    /**
     * Retorna a representação de um documento 
     * @param nome Nome do documento
     * @return Lista dos elementos do documento
     */
    public String[] exibiDocumento(String nome) {
        return documentos.get(nome).ShowElementos();
    }
}
