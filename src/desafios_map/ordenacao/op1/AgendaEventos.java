package desafios_map.ordenacao.op1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    
    Map<LocalDate, Evento> agendaEventos;

    public AgendaEventos(){
        this.agendaEventos = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String atracao){
        Evento evento = new Evento(nomeEvento, atracao);
        agendaEventos.put(data, evento);
    }

    // O TreeMap é uma interface Map, que utiliza uma estrutura de árvore binária de busca balanceada (Red-Black Tree) para armazenar os dados, garantindo que as chaves sejam sempre ordenadas de acordo com a ordem natural ou por meio de um comparador especificado.
    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventos);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            LocalDate dataEvento = entry.getKey();
            Evento evento = entry.getValue();
            System.out.println("Data: "+ dataEvento + ", Evento: "+ evento.getNomeEvento() + ", Atração: " + evento.getAtracao());
            
        }
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        for(Map.Entry<LocalDate, Evento> entry : agendaEventos.entrySet()){
            LocalDate dataEvento = entry.getKey();
            if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)){
               proximaData = dataEvento;
               proximoEvento = entry.getValue();
               break;
            }      
        }
        if (proximoEvento != null) {
            System.out.println("O próximo evento: "+ proximoEvento.getNomeEvento() + ", acontecerá na data "+ proximaData);
        } else {
            System.out.println("Não há eventos futuros na agenda.");
        }
    }

    public static void main(String[] args) {
         AgendaEventos agenda = new AgendaEventos();

         LocalDate data = LocalDate.of(2024, 02, 10);
         agenda.adicionarEvento(data, "MotoGP", "Corrida de moto");
         LocalDate data1 = LocalDate.of(2024, 05, 12);
         agenda.adicionarEvento(data1, "Kart Acelerar", "Corrida de kart com os amigos");
         LocalDate data2 = LocalDate.of(2024,11, 9);
         agenda.adicionarEvento(data2, "Formula1 Gp de interlagos", "Corrida das 12:30 em Interlagos");
         LocalDate data3 = LocalDate.of(2024, 06, 20);
         agenda.adicionarEvento(data3, "Maratona", "Corrida a pé cronometrada");
         LocalDate data4 = LocalDate.of(2024, 12, 20);
         agenda.adicionarEvento(data4, "Desfile", "Desfile da marca xxxx");

         agenda.exibirAgenda();
         
         agenda.obterProximoEvento();
    }
}
