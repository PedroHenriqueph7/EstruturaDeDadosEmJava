package desafios_map.ordenacao.op2;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class LivrariaOnline {
    
    Map<String, Livro> livrariaOnline;
    
    public LivrariaOnline(){
        this.livrariaOnline = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro){
        livrariaOnline.put(link, livro);
    }

    public void removerLivro(String titulo){
        if (!livrariaOnline.isEmpty()) {
            String key = null;
            for(Map.Entry<String, Livro> entry : livrariaOnline.entrySet()){
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                   key = entry.getKey();
                   break;
                }

            }
            livrariaOnline.remove(key);
        } else {
            throw new IllegalStateException("Livraria está vazia!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){

       List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaOnline.entrySet());
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco){
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        
            Map<String, Livro> livrosPesquisados = new LinkedHashMap<>();
           
            for(Map.Entry<String, Livro> entry: livrariaOnline.entrySet()){
                Livro livro = entry.getValue();
                if (livro.getAutor().equals(autor)) {
                   livrosPesquisados.put(entry.getKey(), livro);
                }
            }
            if (livrosPesquisados.size() == 0) {
                System.out.println("Não foi encontrado livros deste autor");
            } 
               
        return livrosPesquisados;   
    }

    public Livro obterLivroMaisCaro(){
       
        double livroComPrecoMaisCaro = Double.MIN_VALUE;
        Livro livroMaisCaro = null;

        if (!livrariaOnline.isEmpty()) {
            for (Livro livro: livrariaOnline.values()) {
                if(livro.getPreco()> livroComPrecoMaisCaro){
                    livroComPrecoMaisCaro = livro.getPreco();
                    livroMaisCaro = livro;
                }
            }
            
        } else{
            throw new NoSuchElementException("A livraria esta vazia!");
        }
        
      return livroMaisCaro;
    }

    public Livro exibirLivroMaisBarato(){
        Livro livroMaisBarato = null;
        double livroComPrecoMaisBarato = Double.MAX_VALUE;
       
        if (!livrariaOnline.isEmpty()) {
            for(Livro livro: livrariaOnline.values()){
                if (livro.getPreco() < livroComPrecoMaisBarato) {
                    livroComPrecoMaisBarato = livro.getPreco();
                    livroMaisBarato = livro;
                }
            }
        } else {
            throw new NoSuchElementException("A Livraria está vazia");
        }

       return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline navegador = new LivrariaOnline();

        Livro livro = new Livro("jsaaa", "Xxxxx Yyyy", 41.10);
        navegador.adicionarLivro("https://www.amazon.com.br/aadddsd/dp", livro);

        Livro livro2 = new Livro("asjifnc", "Sssss S Aaaaa Aaaa", 15.30);
        navegador.adicionarLivro("https://www.amazon.com.br/xxyyyxsy/dp", livro2);

        Livro livro3 = new Livro("Ao ISJkdsao akodo","WWWWW Wedsdd Snj", 33.58);
        navegador.adicionarLivro("https://www.amazon.com.br/xsksjxj/dp", livro3);

        Livro livro4 = new Livro("Inxksork Dekfmssi", "Qqqqiai Iaiajsj", 45.18);
        navegador.adicionarLivro("https://www.amazon.com.br/skskdoods/dp", livro4);

        Livro livro5 = new Livro("A Psaodkff Fiskajs", "Aosodoo Saodkf", 32.10);
        navegador.adicionarLivro("https://www.amazon.com.br/ekeoosod/dp", livro5);


        System.out.println(navegador.exibirLivrosOrdenadosPorPreco()+"\n");
        navegador.removerLivro("Inxksork Dekfmssi");
        System.out.println(navegador.exibirLivrosOrdenadosPorPreco()+"\n");
        Livro livroMaisBarato = navegador.exibirLivroMaisBarato();
        System.out.println("Livro Mais Barato: "+livroMaisBarato);
        Livro livroMaisCaro = navegador.obterLivroMaisCaro();
        System.out.println("Livro Mais Caro: "+livroMaisCaro);
       

    }
}
    

