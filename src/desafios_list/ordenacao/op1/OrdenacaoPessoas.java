package desafios_list.ordenacao.op1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoas(String nome, int idade, double altura){
        Pessoa pessoa = new Pessoa(nome, idade, altura);
        pessoaList.add(pessoa);
    }

    public List<Pessoa> ordenarPorIdade() throws Exception{
        List<Pessoa> pessoaListOrdenadaPorAltura = new ArrayList<>(pessoaList);
        if (!pessoaList.isEmpty()){
            Collections.sort(pessoaListOrdenadaPorAltura);
            return pessoaListOrdenadaPorAltura;
        } else {
            throw new Exception("A lista esta vazia!!");
        }
        
    }

    public List<Pessoa> ordenarPorAltura() throws Exception{
        List<Pessoa> listOrdenadaPorAltura = new ArrayList<>(pessoaList);
        if (!pessoaList.isEmpty()){
            AlturaComparator alturaComparator = new AlturaComparator();
            Collections.sort(listOrdenadaPorAltura, alturaComparator);
            return listOrdenadaPorAltura;
        } else {
            throw new Exception("A lista esta vazia!!");
        }
    }

    public void exibirPessoas(){
        if (!pessoaList.isEmpty()){
            System.out.println("Ordem a qual as pessoas foram inseridas naturalmente");
            for (Pessoa pessoa : pessoaList) {
                System.out.print(pessoa);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
        ordenacaoPessoas.adicionarPessoas("Arlindo", 25, 183);
        ordenacaoPessoas.adicionarPessoas("Fernando", 31, 170);
        ordenacaoPessoas.adicionarPessoas("Leo", 28, 182);
        ordenacaoPessoas.adicionarPessoas("Silva", 24, 190);
        ordenacaoPessoas.adicionarPessoas("Souza", 21, 163);

        ordenacaoPessoas.exibirPessoas();
        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }

}
