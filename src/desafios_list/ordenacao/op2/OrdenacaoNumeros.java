package desafios_list.ordenacao.op2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    List<Integer> numerosList;

    public OrdenacaoNumeros(){
        numerosList = new ArrayList<>();
    }

    public void adicionarNumeros(int num){
        numerosList.add(num);
    }

    public List<Integer> ordenarAscendente() throws Exception{
        List<Integer> ordenadaAscendente = new ArrayList<>(numerosList);
        if (!numerosList.isEmpty()){
            Collections.sort(ordenadaAscendente);
            return ordenadaAscendente;
        } else {
            throw new Exception("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente() throws Exception{
        List<Integer> ordenadaAscendente = new ArrayList<>(numerosList);
        if (!numerosList.isEmpty()){
            ordenadaAscendente.sort(Collections.reverseOrder());
            return ordenadaAscendente;
        } else {
            throw new Exception("A lista está vazia!");
        }
    }

    public void exibirNumeros(){
        if (!numerosList.isEmpty()){
            for (Integer integer : numerosList) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) throws Exception {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.adicionarNumeros(4);
        ordenacaoNumeros.adicionarNumeros(12);
        ordenacaoNumeros.adicionarNumeros(3);
        ordenacaoNumeros.adicionarNumeros(8);
        ordenacaoNumeros.adicionarNumeros(5);
        ordenacaoNumeros.adicionarNumeros(0);
        ordenacaoNumeros.adicionarNumeros(9);

        ordenacaoNumeros.exibirNumeros();

        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
