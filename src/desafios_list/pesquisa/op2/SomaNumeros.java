package desafios_list.pesquisa.op2;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros{
    private List<Integer> numeroList = new ArrayList<>();

    public void adicionarNumero(int numero){
        numeroList.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;

        for (Integer integer : numeroList) {
            soma += integer;
        }

        return soma;
    }

    public void encontrarMaiorNumero(){
         int maiorNumero = Integer.MIN_VALUE;
        for (Integer integer : numeroList) {
            if (integer > maiorNumero) {
                maiorNumero = integer;
            }
        }
        System.out.println("Maior número da List é: "+ maiorNumero);
    }

    public void encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
       for (Integer integer : numeroList) {
           if (integer < menorNumero) {
               menorNumero = integer;
           }
       }
       System.out.println("Menor número da List é: "+ menorNumero);
   }

   public void exibirNumeros(){
        for (Integer integer : numeroList) {
            System.out.print(integer+" ");
        }
        System.out.println();
   }

   public static void main(String[] args) {
       SomaNumeros listaDeNumeros = new SomaNumeros();

       int numero = 10;
       int numero1 = 24;
       int numero2 = numero1 - numero;
       int numero3 = 19;
       int numero4 = 30;

       listaDeNumeros.adicionarNumero(numero);
       listaDeNumeros.adicionarNumero(numero1);
       listaDeNumeros.adicionarNumero(numero2);
       listaDeNumeros.adicionarNumero(numero3);
       listaDeNumeros.adicionarNumero(numero4);

       listaDeNumeros.exibirNumeros();
       listaDeNumeros.encontrarMaiorNumero();
       listaDeNumeros.encontrarMenorNumero();
       int resultado = listaDeNumeros.calcularSoma();
       System.out.println("Soma: "+resultado);
   }
}