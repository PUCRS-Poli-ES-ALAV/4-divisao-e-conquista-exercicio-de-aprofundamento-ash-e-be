package br.pucrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Vamos começar com um algorítmo já estudado e conhecido (em AEDI).
O Merge Sort é um algorítmo de ordenação baseado nos seguintes passos:

recursivamente ordene a metade esquerda do vetor
recursivamente ordene a metade direita do vetor
mescle (faça o merge) das duas metades para ter o vetor ordenado.
Assim:

implemente o algortimo abaixo;
teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576.
Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;

MERGE-SORT(L: List with n elements) : Ordered list with n elements
    IF (list L has one element)
        RETURN L.
    Divide the list into two halves A and B.
    A ← MERGE-SORT(A).
    B ← MERGE-SORT(B).
    L ← MERGE(A, B).
    RETURN L. 
*/
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1, 8, 33, 66, 8, 23822, 2792, 4, 594));

        System.out.println(arr.toString());
        arr = mergeSort(arr);
        System.out.println(arr.toString());
    }

    public static List<Integer> mergeSort(List<Integer> arr){
        List<Integer> result = new ArrayList<>();

        int size = arr.size();
        if (size == 1) {
            return arr;
        }

        // sort
        List<Integer> arrA = arr.subList(0, size / 2);
        List<Integer> arrB = arr.subList(size / 2, size);

        arrA = mergeSort(arrA);
        arrB = mergeSort(arrB);

        // merge
        int j = 0;
        int itemA;
        int itemB;

        // if (arrA.size() == 0) return arrB;

        for (int i = 0; i < arrA.size(); i++){
            itemA = arrA.get(i);

            while (j < arrB.size()){
                itemB = arrB.get(j);

                if (itemB <= itemA) {
                    result.add(itemB);
                    j++;
                } else break;
            }

            result.add(itemA);
        }

        while (j < arrB.size()){
            itemB = arrB.get(j);
            result.add(itemB);
            j++;
        }
        
        return result;
    }
}
