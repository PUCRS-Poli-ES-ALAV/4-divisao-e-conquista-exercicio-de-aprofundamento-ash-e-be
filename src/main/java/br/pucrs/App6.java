package br.pucrs;

/* 
    1. Re-implemente o algoritmo de implementação de multiplicação de grandes
    inteiros, agora sobre duas sequências de bits representados como Strings de 0 e 1. Use a assinatura abaixo:
    // Multiplica duas strings de bits x e y
    // e retorna o resultado como um inteiro "long".
        public static long multiply(String X, String Y);
    
    2. Conte as iteraçõees/instruções e complete a tabela da atividade anterior.
 */
public class App6
{
    private static long iterationCount = 0;

    public static void main( String[] args )
    {   
        long result;
        String x;
        String y;
        long startTime;
        long endTime;
        
        x = "0011";
        y = "0111";
        startTime = System.nanoTime();
        result = multiply(x, y);
        endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 4: " + (endTime - startTime) + " ns");
        System.out.println("Iterations for size 4: " + iterationCount);

        iterationCount = 0;

        x = "0101010111110101";
        y = "1100110000000000";
        startTime = System.nanoTime();
        result = multiply(x, y);
        endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 16: " + (endTime - startTime) + " ns");
        System.out.println("Iterations for size 16: " + iterationCount);

        iterationCount = 0;

        x = "1010101111101001100110101011111010101010101110011001010101111101";
        y = "0101010111001100000000001111010101010101111100110000000000110101";
        startTime = System.nanoTime();
        result = multiply(x, y);
        endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 64: " + (endTime - startTime) + " ns");
        System.out.println("Iterations for size 64: " + iterationCount);
    }

    public static Long multiply(String x, String y) {
        iterationCount++;

        int n = x.length();

        if (n == 1) {
            return Long.parseLong(x) * Long.parseLong(y);
        }
        else {
            int m = n / 2;

            String strA = x.substring(0, m);
            String strB = x.substring(m, n);

            String strC = y.substring(0, m);
            String strD = y.substring(m, n);

            long e = multiply(strA, strC);
            long f = multiply(strB, strD);
            long g = multiply(strB, strC);
            long h = multiply(strA, strD);

            return (long)(Math.pow(2, n) * e + Math.pow(2, m) * (g + h) + f);
        }  
    }
}