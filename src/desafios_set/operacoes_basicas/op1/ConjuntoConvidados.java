package desafios_set.operacoes_basicas.op1;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    
    Set<Convidados> listConvidados;

    public ConjuntoConvidados(){
        this.listConvidados = new HashSet<Convidados>();
    }

    public void adiconarConvidado(Convidados convidados){
        listConvidados.add(convidados);
    }

    public void removerConvidadosPorCódigoConvite(String codigoConvite){
        Set<Convidados> convidadoaSerRemovido = new HashSet<>();
        if (!listConvidados.isEmpty()) {
            for (Convidados interardorConvidados : listConvidados) {
                if (interardorConvidados.getCodigo().equalsIgnoreCase(codigoConvite)) {
                    convidadoaSerRemovido.add(interardorConvidados);
                }
            }
            listConvidados.removeAll(convidadoaSerRemovido);
        } else {
            throw new IllegalStateException("Lista de convidados esta vazia!");
        }
    }

    public void contarConvidados(){
        if (!listConvidados.isEmpty()) {
           System.out.println("Número de Convidados: "+listConvidados.size());
        } else {
            throw new IllegalStateException("Lista de convidados esta vazia!");
        }
    }

    public void exibirConvidados(){
        if (!listConvidados.isEmpty()) {
            System.out.println("Lista de Convidados: ");
            for (Convidados convidados : listConvidados) {
                System.out.println(convidados);
            }
         } else {
             throw new IllegalStateException("Lista de convidados esta vazia!");
         }
    }
}
