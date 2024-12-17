package desafios_map.pesquisa.op1;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EstoqueProdutos {
    Random random = new Random(1);
    Long cod;
    Map<Long, Produto> estoqueProdutos;
    
    public EstoqueProdutos(){
        this.estoqueProdutos = new HashMap<>();
    }

    public void adicionarProduto(String nome, int quantidade, double preco){
            Produto produto = new Produto(nome, quantidade, preco);
            cod = random.nextLong(1000);
            estoqueProdutos.put(cod, produto);
    }

    
    public void exibirProdutos() throws Exception{
        if (!estoqueProdutos.isEmpty()){
            for(Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()){
               System.out.println("Código = "+ entry.getKey() +" = " +entry.getValue());
            }
        } else {
            throw new IllegalStateException("O Estoque de Produtos se encontra vazio!");
        }
    }

    public double calcularValorTotalEstoque() throws Exception{
        double valorTotalEstoque = 0.0;
        if (!estoqueProdutos.isEmpty()) {
            for (Map.Entry<Long, Produto> entry: estoqueProdutos.entrySet()) {
                Produto produto = entry.getValue();
                double operacaoParcial = produto.getQuantidade() * produto.getPreco();
                valorTotalEstoque += operacaoParcial;
            } 
        } else {
            throw new IllegalStateException("Sem Produtos no estoque");
        }
        

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        double valorProdutoMaisCaro = Double.MIN_VALUE;
        Produto produtoMaisCaro = null;
       
        if (!estoqueProdutos.isEmpty()){
            for (Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()) {
                Produto produto = entry.getValue();
                if (produto.getPreco() > valorProdutoMaisCaro){
                    valorProdutoMaisCaro = produto.getPreco();
                    produtoMaisCaro = produto;
                }
                
            }
           return produtoMaisCaro;
        } else {
            throw new IllegalStateException("Sem Produtos no estoque!");
        }

    }

    public Produto obterProdutoMaisBarato(){
        double valorProdutoMaisBarato = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;
       
        if (!estoqueProdutos.isEmpty()){
            for (Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()) {
                Produto produto = entry.getValue();
                if (produto.getPreco() < valorProdutoMaisBarato){
                    valorProdutoMaisBarato = produto.getPreco();
                    produtoMaisBarato = produto;
                }
                
            }
           return produtoMaisBarato;
        } else {
            throw new IllegalStateException("Sem Produtos no estoque!");
        }

    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
         
         Produto produtoComMaiorValorNoEstoque = null;
         double valorTotalDoProduto;
         double maiorValorNoEstoqueDProduto = Double.MIN_VALUE;

         if (!estoqueProdutos.isEmpty()){
            for(Map.Entry<Long, Produto> entry :estoqueProdutos.entrySet()){
                 Produto produto = entry.getValue();
                 valorTotalDoProduto = produto.getPreco() * produto.getQuantidade();
                 if (valorTotalDoProduto > maiorValorNoEstoqueDProduto) {
                    maiorValorNoEstoqueDProduto = valorTotalDoProduto;
                    produtoComMaiorValorNoEstoque = produto;
                 }
                
                    
            }
            return produtoComMaiorValorNoEstoque;
        }else {
            throw new IllegalStateException("Sem Produtos no estoque");
        }
     }
    



    public static void main(String[] args) {
        try {
            EstoqueProdutos estoqueProdutos = new EstoqueProdutos();
            estoqueProdutos.adicionarProduto("Cadeira", 4, 150);
            estoqueProdutos.adicionarProduto("Mesa", 2, 320);
            estoqueProdutos.adicionarProduto("Televisão", 5, 1200);
            estoqueProdutos.adicionarProduto("Espelho", 3, 90);
            estoqueProdutos.adicionarProduto("Caixa de Som", 1, 555);
            estoqueProdutos.exibirProdutos();

            double valorTotalEstoque = estoqueProdutos.calcularValorTotalEstoque();
            System.out.println("Valor total do Estoque: "+valorTotalEstoque);

            Produto produtoMaisCaro = estoqueProdutos.obterProdutoMaisCaro();
            System.out.println("Produto com maior valor unitário do estoque: "+produtoMaisCaro);

            Produto produtoMaisBarato = estoqueProdutos.obterProdutoMaisBarato();
            System.out.println("Produto com menor valor unitário do estoque: "+produtoMaisBarato);

            Produto produtoComMaiorValorNoEstoque = estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
            System.out.println("Produto Com maior Valor no Estoque: "+produtoComMaiorValorNoEstoque);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
