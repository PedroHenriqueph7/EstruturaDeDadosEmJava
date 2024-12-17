package desafios_map.pesquisa.op2;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    
    Map<String, Integer> contagemPalavras;

    public ContagemPalavras(){
        this.contagemPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        contagemPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!contagemPalavras.isEmpty()) {
            contagemPalavras.remove(palavra);
        } else {
            throw new IllegalStateException("Não há a palavras a serem removidas");
        }
    }

    public void exibirPalavras(){
        if (!contagemPalavras.isEmpty()) {
            for(Map.Entry<String, Integer> entry : contagemPalavras.entrySet()){
                System.out.println("Palavra = "+entry.getKey()+ ", quantidade de repetições no texto  = "+ entry.getValue());
            }
        }
    }

    public String encontrarPalavrasMaisFrequentes(){
        String palavraMaisFrequente = null;
        int repeticoesDaPalavraTexto = Integer.MIN_VALUE;

        if (!contagemPalavras.isEmpty()) {
            for(Map.Entry<String, Integer> entry : contagemPalavras.entrySet()){
                if (entry.getValue() > repeticoesDaPalavraTexto) {
                    repeticoesDaPalavraTexto = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
            return "Palavra mais encontrada no texto = "+ palavraMaisFrequente+ ", Número de Repeticões: "+ repeticoesDaPalavraTexto;
        } else {
            throw new IllegalStateException("Não há palavras com repeticões no texto");
        }
    }


    public static void main(String[] args) {
        
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Azul", 4);
        contagemPalavras.adicionarPalavra("quando", 2);
        contagemPalavras.adicionarPalavra("modo", 1);
        contagemPalavras.adicionarPalavra("ele", 3);
        contagemPalavras.adicionarPalavra("carro", 6);
        contagemPalavras.adicionarPalavra("horas", 2);

        contagemPalavras.removerPalavra("horas");
        contagemPalavras.exibirPalavras();
        System.out.println(contagemPalavras.encontrarPalavrasMaisFrequentes());
        
    }
}
