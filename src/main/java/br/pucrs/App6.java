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
        Long result;
        String a, b;
        long startTime, endTime; 
        iterationCount = 0;

        long x = 01010001;
        long y = 11010101;
        startTime = System.currentTimeMillis();
        result = multiply(x, y);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 8: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 8: " + iterationCount);

        // a = "00101001";
        // b = "01101010";
        // startTime = System.currentTimeMillis();
        // result = multiply(a, b);
        // endTime = System.currentTimeMillis();
        // System.out.println("Result: " + result);
        // System.out.println("Time taken for size 8: " + (endTime - startTime) + " ms");
        // System.out.println("Iterations for size 8: " + iterationCount);

        // iterationCount = 0;

        // a = "0010100101101010";
        // b = "0110101000101001";
        // startTime = System.currentTimeMillis();
        // result = multiply(a, b);
        // endTime = System.currentTimeMillis();
        // System.out.println("Result: " + result);
        // System.out.println("Time taken for size 8: " + (endTime - startTime) + " ms");
        // System.out.println("Iterations for size 8: " + iterationCount);

        // iterationCount = 0;

        // a = "0010100101101010001010010110101000101001011010100010100101101010";
        // b = "0110101000101001011010100010100101101010001010010110101000101001";
        // startTime = System.currentTimeMillis();
        // result = multiply(a, b);
        // endTime = System.currentTimeMillis();
        // System.out.println("Result: " + result);
        // System.out.println("Time taken for size 8: " + (endTime - startTime) + " ms");
        // System.out.println("Iterations for size 8: " + iterationCount);
    }

    // public static Long multiply(String a, String b) {
        
    //     return 0;
    // }

    public static Long multiply(Long x, Long y) {
        long result;
        int n = x.toString().length();

        if (n == 1) {
            return x * y;
        }

        String strX = String.valueOf(x);
        String strY = String.valueOf(y);

        String strFirstHalfX = strX.substring(0, n/2);
        String strSecondHalfX = strX.substring(n/2, n);

        String strFirstHalfY = strY.substring(0, n/2);
        String strSecondHalfY = strY.substring(n/2, n);

        Long firstHalfX = Long.parseLong(strFirstHalfX);
        Long secondHalfX = Long.parseLong(strSecondHalfX);

        Long firstHalfY = Long.parseLong(strFirstHalfY);
        Long secondHalfY = Long.parseLong(strSecondHalfY);

        result = (long)Math.pow(2, n) * multiply(firstHalfX, firstHalfY) +
                 (long)Math.pow(2, n/2) * (multiply(secondHalfX, secondHalfY) + multiply(secondHalfX, firstHalfY)) +
                 multiply(secondHalfX, secondHalfY);

        return result;
    }
}
