package desafios_set.pesquisa.op2;

public class Tarefa  implements Comparable<Tarefa>{
    
    private String descricao;
    private boolean estado;

    public Tarefa(String descricao, boolean estado){
        this.descricao = descricao;
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int compareTo(Tarefa t) {
        return this.descricao.compareToIgnoreCase(t.getDescricao());
    }
    
    

    

    @Override
    public String toString() {
        return "______________________________________________________________________\n"
              +"Tarefa [descricao= " + descricao + ", estado= " + estado + "]\n"
               ;
    }

  
}