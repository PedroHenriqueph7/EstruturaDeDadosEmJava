package desafios_list.operacoes_basicas.op2;

public class Item {
    private String nome;
    private double preco;
    private int quantidade;

    public Item(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Item(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
   
    public int getQuantidade() {
        return quantidade;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [nome = " + nome + ", preco = " + preco + ", quantidade = " + quantidade + " ]";
    } 

    
}
