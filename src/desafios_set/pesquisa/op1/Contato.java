package desafios_set.pesquisa.op1;



public class Contato implements Comparable<Contato>{
    
    private String nome;
    private String telefone;
   
    
    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getTelefone() {
        return telefone;
    }


    @Override
    public String toString() {
        return "[Nome = " + nome + ", Telefone = " + telefone + "]";
    }


    @Override
    public int compareTo(Contato c) {
        return this.nome.compareTo(c.getNome());
    }

    
}
