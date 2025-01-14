package desafios_set.operacoes_basicas.op2;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
        
        Set<String> conjuntodePalavrasUnicas;
        
        public ConjuntoPalavrasUnicas(){
            conjuntodePalavrasUnicas = new HashSet<>();
        }

        public void adicionarPalavra(String palavra){
            conjuntodePalavrasUnicas.add(palavra);
        }

        public void removerPalavra(String palavra) throws Exception{
            Set<String> palavraUnicaParaRemocao = new HashSet<>();
            if (!conjuntodePalavrasUnicas.isEmpty()) {
                for (String s : conjuntodePalavrasUnicas) {
                    if (s.equalsIgnoreCase(palavra)) {
                        palavraUnicaParaRemocao.add(s);
                    }
                     
                }
                if (palavraUnicaParaRemocao.isEmpty()) {
                    System.out.println("Palavra não encontrada dentro do conjunto");
                }
            conjuntodePalavrasUnicas.removeAll(palavraUnicaParaRemocao);    
            } else {
                throw new Exception("O conjunto de palavras está vazio!");
            }
        }

        @SuppressWarnings("null")
        public void verificarPalavra(String palavra) throws Exception{
                Integer interador = null;
                for (String s : conjuntodePalavrasUnicas) {
                    if (s.equalsIgnoreCase(palavra)) {
                        System.out.println("Palavra unica esta presente no conjunto!");
                        interador++;
                    }
                     
                }
                if (interador == null) {
                    System.out.println("Palavra não encontrada no conjunto");
                }
        }

        public void exibirConjuntoPalavrasUnicas(){
            System.out.println("Conjunto de Palavras Únicas: ");
            for (String s : conjuntodePalavrasUnicas) {
                System.out.print(s+", ");
            }
            System.out.println();
        }
    

        public static void main(String[] args) throws Exception {
            
            ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();

            conjunto.adicionarPalavra("Livro");
            conjunto.adicionarPalavra("Caderno");
            conjunto.adicionarPalavra("Lapis");
            conjunto.adicionarPalavra("Caneta");
            conjunto.adicionarPalavra("Corretivo");
            conjunto.adicionarPalavra("Borracha");
            conjunto.adicionarPalavra("Apontador");
            conjunto.adicionarPalavra("Lapiseira");
            conjunto.adicionarPalavra("Mochila");

            try {
                conjunto.exibirConjuntoPalavrasUnicas();
                conjunto.removerPalavra("Apontador");
                conjunto.verificarPalavra("Apontador");
                conjunto.exibirConjuntoPalavrasUnicas();
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
           

        }

}