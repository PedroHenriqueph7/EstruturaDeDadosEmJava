package desafios_map.operacoes_basicas.op1;

import java.util.Map;
import java.util.TreeMap;

public class AgendaContatos {
    
    Map<String, Integer> agendaContatos;

    public AgendaContatos() {
        this.agendaContatos = new TreeMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatos.put(nome, telefone);
    }

    public void removerContato(String nome){
        if (!agendaContatos.isEmpty()){
            agendaContatos.remove(nome);
        } else {
            System.out.println("A lista de contatos esta vazia!");
        }  
    }

    public void exibirContatos(){
        if(!agendaContatos.isEmpty()){
            System.out.print(agendaContatos.entrySet());
            System.out.println();
        } else {
            System.out.println("A lista de Contatos esta vazia!");
        }
        
    }

    public void pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatos.isEmpty()) {
           System.out.println("Contato: "+ agendaContatos.get(nome));  
           numeroPorNome = agendaContatos.get(nome);
           if(numeroPorNome == null){
            System.out.println("Nome não encontrado na lista de contatos!");
           } 
        } else{
            System.out.println("A lista de contatos esta vazia");
        }
        
        
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Leo", 999222223);
        agendaContatos.adicionarContato("Fernanda", 999222225);
        agendaContatos.adicionarContato("Raimundo", 999222224);
        agendaContatos.adicionarContato("Suzi", 999222226);
        agendaContatos.adicionarContato("Soares", 999222227);

        agendaContatos.exibirContatos();
        agendaContatos.removerContato("Leo");
        agendaContatos.pesquisarPorNome("Fernanda");
        agendaContatos.pesquisarPorNome("Pedro");
        agendaContatos.exibirContatos();
        
    }
}
