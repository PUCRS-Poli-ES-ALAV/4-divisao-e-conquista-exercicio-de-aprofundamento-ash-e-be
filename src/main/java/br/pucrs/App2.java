package br.pucrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class App2
{
    private static long iterationCount = 0;

    public static void main( String[] args )
    {   
        Long result;
        
        List<Long> arr32 = generateRandomList(32);
        long startTime = System.nanoTime();
        result = maxValue(arr32, 32);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 32: " + (endTime - startTime) + " ns");
        System.out.println("Iterations for size 32: " + iterationCount);

        iterationCount = 0;

        List<Long> arr2048 = generateRandomList(2048);
        startTime = System.nanoTime();
        result = maxValue(arr2048, 2048);
        endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 2048: " + (endTime - startTime) + " ns");
        System.out.println("Iterations for size 2048: " + iterationCount);

        iterationCount = 0;

        List<Long> arr1048576 = generateRandomList(1048576);
        // System.out.println("Input: " + arr1048576);
        startTime = System.nanoTime();
        result = maxValue(arr1048576, 1048576);
        endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 1,048,576: " + (endTime - startTime) + " ns");
        System.out.println("Iterations for size 1,048,576: " + iterationCount);
    }

    public static Long maxValue(List<Long> arr, int n) {
        if (n == 1) return arr.get(0);
        
        Long max = arr.get(0);
        for (int i = 1; i < n; i++) {  
            if (arr.get(i) > max) max = arr.get(i);

            iterationCount++;
        }
        return max;
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
