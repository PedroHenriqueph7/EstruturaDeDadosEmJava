package desafios_list.operacoes_basicas.op1;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private List<Tarefa> listaTarefas = new ArrayList<Tarefa>();

    public void adicionarTarefas(String descricao){
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefas(String descricao){
        List<Tarefa> tarefaaSerRemovida = new ArrayList<Tarefa>();
        if (!listaTarefas.isEmpty()){
           for (Tarefa tarefa : listaTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaaSerRemovida.add(tarefa);
                }
           }
           listaTarefas.removeAll(tarefaaSerRemovida);
        } else {
            System.out.println("Lista de tarefa vazia!");
        }
    }

    public void obterNumeroTotalTarefas(){
       System.out.println("Número total de tarefas: "+ listaTarefas.size());
    }

    public List<Tarefa> obterDescricaoTarefas(){
        return listaTarefas;
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefas("Correr no parque");
        listaTarefas.adicionarTarefas("Jogar bola");
        listaTarefas.adicionarTarefas("Estudar");
        
        listaTarefas.removerTarefas("Correr no parque");
        listaTarefas.obterNumeroTotalTarefas();
        System.out.println(listaTarefas.obterDescricaoTarefas());
    }
}
