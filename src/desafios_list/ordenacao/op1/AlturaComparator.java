package desafios_list.ordenacao.op1;

import java.util.Comparator;

public class AlturaComparator implements Comparator<Pessoa>{

    @Override
    public  int compare(Pessoa p1, Pessoa p2) {
         return Double.compare(p1.getAltura(), p2.getAltura());
    }
    
}
