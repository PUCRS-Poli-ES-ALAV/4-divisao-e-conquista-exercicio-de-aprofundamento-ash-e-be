package br.pucrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
O algoritmo a seguir (que utiliza divisão-e-conquista) encontra o maior valor em um vetor.

Assim, novamente:

implemente o algortimo abaixo;
teste-o para vetores de inteiros com conteúdos randômicos, e tamanho 32, 2048 e 1.048.576. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto;
long maxVal2(long A[], int init, int end) {  
    if (end - init <= 1)
        return max(A[init], A[end]);  
    else {
          int m = (init + end)/2;
          long v1 = maxVal2(A,init,m);   
          long v2 = maxVal2(A,m+1,end);  
          return max(v1,v2);
         }
}
 */
public class App3
{
    private static long iterationCount = 0;

    public static void main( String[] args )
    {   
        Long result;
        
        List<Long> arr32 = generateRandomList(32);
        long startTime = System.currentTimeMillis();
        result = maxValue(arr32, 32);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 32: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 32: " + iterationCount);

        iterationCount = 0;

        List<Long> arr2048 = generateRandomList(2048);
        startTime = System.currentTimeMillis();
        result = maxValue(arr2048, 2048);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 2048: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 2048: " + iterationCount);

        iterationCount = 0;

        List<Long> arr1048576 = generateRandomList(1048576);
        // System.out.println("Input: " + arr1048576);
        startTime = System.currentTimeMillis();
        result = maxValue(arr1048576, 1048576);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 1,048,576: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 1,048,576: " + iterationCount);
    }

    public static Long maxValue(List<Long> vector, int size) {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            return vector.get(0);
        }
        
        // divide o vetor na metade
        List<Long> arrA = vector.subList(0, size / 2);
        List<Long> arrB = vector.subList(size / 2, size);

        // encontra o maior valor em cada metade
        Long maxA = maxValue(arrA, arrA.size());
        Long maxB = maxValue(arrB, arrB.size());

        iterationCount += 1;

        // retorna o maior valor entre os dois  
        if (maxA > maxB) return maxA;
        else return maxB;

        // Long max = vector.get(0);
        // for (int i = 1; i < size; i++) {
        //     if (vector.get(i) > max) {
        //         max = vector.get(i);
        //     }
        // }
        // return max;
    }

    public static List<Long> generateRandomList(int size) {
        List<Long> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextLong());
        }
        return list;
    }

}
