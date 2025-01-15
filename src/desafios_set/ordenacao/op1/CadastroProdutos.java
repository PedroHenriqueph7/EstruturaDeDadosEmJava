package desafios_set.ordenacao.op1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    Set<Produto> cadastroProdutos;

    public CadastroProdutos(){
        cadastroProdutos = new TreeSet<>();
    }

    public void adicionarProduto(String nome, int cod, double precoo, int quantidade){
            Produto produto = new Produto(nome, cod, precoo, quantidade);
        cadastroProdutos.add(produto);
    }

    public void removerProduto(int cod){
        Set<Produto> removerProduto = new HashSet<>();
        boolean produtoEncontrado = false;
        for (Produto p : cadastroProdutos) {
            if (p.getCodigo() == cod) {
                removerProduto.add(p);
                produtoEncontrado = true;
            }
            
        }

        if (produtoEncontrado == true) {
            cadastroProdutos.removeAll(removerProduto);
            System.out.println("Remoção efetuada");
        } else {
            System.out.println("PRoduto não Encontrado!");
        }
    }
    public Set<Produto> exibirProdutosPorNome() {
        return cadastroProdutos;
    }

    public List<Produto> exibirProdutosPorPreco() throws Exception {
        if (!cadastroProdutos.isEmpty()) {
            List<Produto> produtosPorPreco = new ArrayList<>(cadastroProdutos);
            ProdutoComparator comparator = new ProdutoComparator();
            Collections.sort(produtosPorPreco, comparator);
            
            return produtosPorPreco;
        } else {
            throw new Exception("Cadastro Vazio!");
        }
        
    }

    public static void main(String[] args) throws Exception {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        try {
            cadastroProdutos.adicionarProduto("arroz 5kg",907754,  23.50, 100);
            cadastroProdutos.adicionarProduto("feijão 1kg",907524,  3.80, 80);
            cadastroProdutos.adicionarProduto("oléo",857754,  8.00, 40);
            cadastroProdutos.adicionarProduto("peito de frango 1kg",627054,  17.85, 90);
            cadastroProdutos.adicionarProduto("café",707704,  19.00, 50);
            cadastroProdutos.adicionarProduto("maionese",407704,  2.25, 150);
            cadastroProdutos.adicionarProduto("fubá",327754,  1.00, 200);
            cadastroProdutos.adicionarProduto("extrato de tomate",717754,  3.25, 80);
            cadastroProdutos.adicionarProduto("mussarela 1kg",677754,  39.60, 30);
            cadastroProdutos.adicionarProduto("caixa de bom bom",807754,  9.00, 300);

            cadastroProdutos.removerProduto(677754);
            System.out.println(cadastroProdutos.exibirProdutosPorNome());
            System.out.println();
            System.out.println(cadastroProdutos.exibirProdutosPorPreco());
        } catch (Exception e) {
           System.err.println(e.getMessage());
        }
        
    }
}
