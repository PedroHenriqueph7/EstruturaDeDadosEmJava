package desafios_set.operacoes_basicas.op1;

public class Convidados {
    private String Nome;
    private String codigoConvite;
    
    public Convidados(String nome, String codigoConvite) {
        Nome = nome;
        this.codigoConvite = codigoConvite;
    }

    public String getNome() {
        return Nome;
    }

    public String getCodigo() {
        return codigoConvite;
    }

    @Override
    public String toString() {
        return "Convidados [Nome=" + Nome + ", codigoConvite=" + codigoConvite + "]";
    }

    

    
}
