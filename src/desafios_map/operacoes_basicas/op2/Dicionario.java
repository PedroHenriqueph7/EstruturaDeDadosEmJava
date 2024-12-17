package desafios_map.operacoes_basicas.op2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dicionario {
    
    Map<String, String> dicionario;

    public Dicionario(){
        this.dicionario = new LinkedHashMap<>();
    }

    public void adicionarPalavra(String palavra, String descricao){
        dicionario.put(palavra, descricao);
    }

    public void removerPalavra(String palavra){
        if (!dicionario.isEmpty()) {
            dicionario.remove(palavra);
            System.out.println("Palavra especificada foi removida com sucesso!");
        } else if (dicionario.size() == 0){
            System.out.println("O dicionário se encontra vazio!");
        } 
    }

    public void exibirDicionario(){

        if (!dicionario.isEmpty()) {
            System.out.println(dicionario.entrySet());
            System.out.println();
        } else {
            System.out.println("O Dicionário se encontra vazio!");
        }
        
    }

    public String pesquisarPorPalavra(String palavra){
        String significadoPalavra = dicionario.get(palavra);
        if (significadoPalavra != null) {
           return significadoPalavra;
        }
           return "Palavra não encontrada no dicionário!";
        }
        
    public static void main(String[] args) {
        
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Alvísssaras", "Espressão de Alegria por notícia recebida");
        dicionario.adicionarPalavra("Balaústre", "Pequena coluna ornamentada utilizada em cercas");
        dicionario.adicionarPalavra("Beneplácito", "Consentimento ou aprovação");
        dicionario.adicionarPalavra("Empedernido", "Aquele que não se deixa persuadir ou não se comove");
        dicionario.adicionarPalavra("Filantropo", "Altruísta, benevolente");

        dicionario.exibirDicionario();

        dicionario.removerPalavra("Balaústre");
        System.out.println(dicionario.pesquisarPorPalavra("Filantropo"));
        dicionario.exibirDicionario();
    }
}
