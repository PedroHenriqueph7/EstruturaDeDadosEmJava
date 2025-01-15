package desafios_set.pesquisa.op2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class ListaTarefas {
    Set<Tarefa> listaDeTarefas;

    public ListaTarefas(Set<Tarefa> listaDeTarefas) {
        this.listaDeTarefas = listaDeTarefas;
    }

    public ListaTarefas(){
        listaDeTarefas = new LinkedHashSet<>();
    }

    public void adicionarTarefa(String descricao){
        Tarefa tarefa = new Tarefa(descricao, false);
        listaDeTarefas.add(tarefa);
    }

    public void removerTarefa(String descricao) throws Exception{
        if (!listaDeTarefas.isEmpty()) {
            Set<Tarefa> tarefaParaRemover = new HashSet<>();
            boolean tarefaEncontrada = false;
            for (Tarefa t : listaDeTarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover.add(t);
                    tarefaEncontrada = true;
                }
            }
            if (tarefaEncontrada == true) {
                listaDeTarefas.removeAll(tarefaParaRemover);
                System.out.println("Remoção efetuada!");
            } else {
                System.out.println("Tarefa não encontrada!");
            }
       
        } else {
            throw new Exception("Lista de Tarefas vazia!!");
        }
    }

    public void exibirTarefas(){
        System.out.println("LISTA DE TAREFAS DO DIA 15/01/2025");
         for (Tarefa t : listaDeTarefas) {
            System.out.print(t);
         }
         System.out.print("______________________________________________________________________\n");
    }

    public int contarTarefas(){
         return listaDeTarefas.size();
    }

    public void obterTarefasConcluidas(){
        boolean tarefasConcluidaEncontrada = false;
        for (Tarefa t : listaDeTarefas) {
            if (t.getEstado()) {
                System.out.print(t);
                tarefasConcluidaEncontrada = true;
            }
         }
         if (!tarefasConcluidaEncontrada) {
            System.out.println("Não Há tarefas concluidas");
         }
    }

    public void obterTarefasPendentes(){
        boolean tarefaPendenteEncontrada = false;
        for (Tarefa t : listaDeTarefas) {
            if (!t.getEstado()) {
                System.out.print(t);
                tarefaPendenteEncontrada = true;
            }
         }
         if (!tarefaPendenteEncontrada) {
            System.out.println("Não Há tarefas pendentes!");
         }
    }

    public void marcarTarefaConcluida(String descricao){
        for (Tarefa t : listaDeTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setEstado(true);
            }
         }
    }

    public void marcarTarefaPendente(String descricao){
        for (Tarefa t : listaDeTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setEstado(false);
            }
         }
    }

    public void limparTarefas(){
        listaDeTarefas.clear();
        if (listaDeTarefas.size() == 0) {
            System.out.println("Tarefas deletadas com Sucesso!");
        }
    }
    

    public static void main(String[] args) throws Exception {
        ListaTarefas listaTarefas = new ListaTarefas();

        try {
            listaTarefas.adicionarTarefa("Acordar as 6:00 da manhã");
            listaTarefas.adicionarTarefa("Arrumar a casa");
            listaTarefas.adicionarTarefa("Lavar a roupa");
            listaTarefas.adicionarTarefa("Verificar o e-mail");
            listaTarefas.adicionarTarefa("Java program");
            listaTarefas.adicionarTarefa("CSS Frontend");
            listaTarefas.adicionarTarefa("Corta o cabelo");
            listaTarefas.adicionarTarefa("Limpar a casa");
            listaTarefas.adicionarTarefa("Preparar a Janta/ carne da semana");
            listaTarefas.adicionarTarefa("Dormir o mais cedo possivel");

            listaTarefas.exibirTarefas();
            listaTarefas.removerTarefa("Arrumar a casa");
            listaTarefas.contarTarefas();
            listaTarefas.obterTarefasConcluidas();
            listaTarefas.obterTarefasPendentes();
            listaTarefas.marcarTarefaConcluida("Acordar as 6:00 da manhã");
            listaTarefas.marcarTarefaConcluida("Lavar a roupa");
            listaTarefas.marcarTarefaConcluida("Verificar o e-mail");
            listaTarefas.marcarTarefaConcluida("Java Program");
            listaTarefas.marcarTarefaPendente("Java Program");

            listaTarefas.exibirTarefas();
            listaTarefas.limparTarefas();
            System.out.println("Total de tarefas na lista: "+listaTarefas.contarTarefas());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
}
