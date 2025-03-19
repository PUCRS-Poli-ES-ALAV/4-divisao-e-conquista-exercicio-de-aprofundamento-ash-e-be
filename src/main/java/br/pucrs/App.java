package br.pucrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

/* 
O algoritmo a seguir (que não utiliza divisão-e-conquista) encontra o maior valor em um vetor.

Assim, novamente:

implemente o algortimo abaixo;
teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
long maxVal1(long A[], int n) {  
    long max = A[0];
    for (int i = 1; i < n; i++) {  
        if( A[i] > max ) 
           max = A[i];
    }
    return max;
}
 */
public class App 
{
    private static long iterationCount = 0;

    public static void main( String[] args )
    {
        List<Integer> arr32 = generateRandomList(32);
        System.out.println("Input: " + arr32);
        long startTime = System.currentTimeMillis();
        arr32 = mergeSort(arr32);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + arr32);
        System.out.println("Time taken for size 32: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 32: " + iterationCount);

        iterationCount = 0;

        List<Integer> arr2048 = generateRandomList(2048);
        System.out.println("Input: " + arr2048);
        startTime = System.currentTimeMillis();
        arr2048 = mergeSort(arr2048);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + arr2048);
        System.out.println("Time taken for size 2048: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 2048: " + iterationCount);

        iterationCount = 0;

        List<Integer> arr1048576 = generateRandomList(1048576);
        // System.out.println("Input: " + arr1048576);
        startTime = System.currentTimeMillis();
        arr1048576 = mergeSort(arr1048576);
        endTime = System.currentTimeMillis();
        // System.out.println("Result: " + arr1048576);
        System.out.println("Time taken for size 1,048,576: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 1,048,576: " + iterationCount);
    }

    public static List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt());
        }
        return list;
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

        for (int i = 0; i < arrA.size(); i++){
            itemA = arrA.get(i);

            while (j < arrB.size()){
                itemB = arrB.get(j);
                iterationCount++;

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
            iterationCount++;
        }
        
        return result;
    }
}
