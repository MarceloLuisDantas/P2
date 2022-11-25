package agenda;

/**
 * Clase responsavel por representar um contato
 * 
 * @author Marcelo Dantas   
 */
public class Contato {
    private String nome;
    private String numero;

    Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() { 
        return this.nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getNumero() { 
        return this.numero; 
    }
    public void setNumero(String numero) { 
        this.numero = numero; 
    }

    public String toString() {
        return String.format("%s - %s", nome, numero);
    }

    public boolean equals(Contato contato) {
        boolean nome = this.nome.equals(contato.getNome());
        boolean numero = this.numero.equals(contato.getNumero());
        return (nome && numero);
    }
}
