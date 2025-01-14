package desafios_set.pesquisa.op1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AgendaContatos {
    
    Set<Contato> agendaContatos;

    public AgendaContatos(){
        agendaContatos = new HashSet<>();
    }

    public void adicionarContato(String nome, String numeroTelefone){
            Contato contato = new Contato(nome, numeroTelefone);
        agendaContatos.add(contato);
    }

    public void exibirContatos(){
        if (!agendaContatos.isEmpty()) {
            List<Contato> agendaOrdenada = new ArrayList<>(agendaContatos);
            System.out.println("Lista de Contatos: ");
                Collections.sort(agendaOrdenada);
            for (Contato c : agendaOrdenada) {
                System.out.println(c);
            }
        } else {
            System.out.println("lista de contatos vazia!");
        }
    }

    public void pesquisarPorNome(String nome){
        boolean contatoEncontrado = false;
        for (Contato c : agendaContatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Contato = "+c);
                contatoEncontrado = true;
            }
        }
        if (contatoEncontrado == false) {
            System.out.println("Contato não encontrado");
        }
    }

    public void atualizarNumeroContato(String nome){
        Scanner scanner = new Scanner(System.in);
        for (Contato c : agendaContatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Digite o número novo: ");
                String novoNumero = scanner.nextLine();
                c.setTelefone(novoNumero);
                System.out.println("Número Atualizado!");
            }
        }
        scanner.close();
    }


    public static void main(String[] args) {
        AgendaContatos agendaDeContatos = new AgendaContatos();

        agendaDeContatos.adicionarContato("Pedro", "10999999999");
        agendaDeContatos.adicionarContato("Souza", "10999999998");
        agendaDeContatos.adicionarContato("Fernando", "10999999997");
        agendaDeContatos.adicionarContato("Ellen", "10999999996");
        agendaDeContatos.adicionarContato("Maria", "10999999995");
        agendaDeContatos.adicionarContato("Fernanda", "10999999994");
        agendaDeContatos.adicionarContato("Elizabeth", "10999999993");
        agendaDeContatos.adicionarContato("Luiz", "10999999992");
        agendaDeContatos.adicionarContato("Fred", "10999999991");
        agendaDeContatos.adicionarContato("Gustavo", "10999999990");

        agendaDeContatos.exibirContatos();
        agendaDeContatos.pesquisarPorNome("Fred");
        agendaDeContatos.atualizarNumeroContato("Ellen");
    }
}
