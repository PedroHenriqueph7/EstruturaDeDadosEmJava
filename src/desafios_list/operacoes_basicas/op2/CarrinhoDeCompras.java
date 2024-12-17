package desafios_list.operacoes_basicas.op2;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> carrinhoDeCompras;

    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new LinkedList<Item>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        carrinhoDeCompras.add(item);
    }

    public void removerItem(String nome){
        if (!carrinhoDeCompras.isEmpty()){
            carrinhoDeCompras.removeIf(item -> item.getNome().equals(nome));
        } else {
            System.out.println("Carrinho de Compras Vazio!");
        }
    }
    
    public double calcularValorTotal() throws Exception{
        double valorTotalDoCarrinhoDeCompras = 0;
         if (!carrinhoDeCompras.isEmpty()){
            for (Item item : carrinhoDeCompras) {
                valorTotalDoCarrinhoDeCompras += item.getPreco() * item.getQuantidade();
            }
         } else {
            throw new Exception("ERRO = Não foi possivel calcular o valor total do carrinho de compras pois o mesmo está vazio");
         }

         return valorTotalDoCarrinhoDeCompras;
    }


    public void exibirItens(){
        for (Item item : carrinhoDeCompras) {
            System.out.println(item);
        }
    }


    public static void main(String[] args) {

        try {
            CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
            
            carrinhoDeCompras.adicionarItem("Chaveiro", 10, 2);
            carrinhoDeCompras.adicionarItem("Ventilador", 120, 1);
            carrinhoDeCompras.adicionarItem("Caderno", 30, 5);
            carrinhoDeCompras.adicionarItem("Fogao", 1120, 1);
            carrinhoDeCompras.exibirItens();
            double valortotaldoCarrinho = carrinhoDeCompras.calcularValorTotal();
            System.out.println("Valor total do carrinho: "+ valortotaldoCarrinho);
            carrinhoDeCompras.removerItem("Chaveiro");
            carrinhoDeCompras.exibirItens();
            System.out.println("Valor total do carrinho: "+ carrinhoDeCompras.calcularValorTotal());

        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
       
    }
}
