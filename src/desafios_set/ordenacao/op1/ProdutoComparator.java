package desafios_set.ordenacao.op1;

import java.util.Comparator;

public class ProdutoComparator implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(),p2.getPreco());
    }
    
}
