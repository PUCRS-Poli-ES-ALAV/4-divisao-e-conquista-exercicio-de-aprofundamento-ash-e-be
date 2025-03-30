package br.pucrs;
/*
    A Multiplicação Inteira de n-bits recebe dois números
    inteiros x e y de n-bits e retorna o resutado de x * y.

    Assim, novamente:

    implemente o algortimo abaixo;
    teste-o para os 3 casos de valores inteiros: com 4 bits, com 16 bits e com 64 bits.
    Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto.
    O algoritmo está dado abaixo:

    MULTIPLY(x, y, n) 
    IF (n = 1)
        RETURN x * y;
    ELSE
        m ← ⎡ n / 2 ⎤;
        a ← ⎣ x / 2^m ⎦;
        b ← x mod 2^m;
        c ← ⎣ y / 2^m ⎦;
        d ← y mod 2^m;
        e ← MULTIPLY(a, c, m);
        f ← MULTIPLY(b, d, m);
        g ← MULTIPLY(b, c, m);
        h ← MULTIPLY(a, d, m);
        RETURN 2^(2m)*e + 2^m*(g + h) + f;
    Ajuste a assinatura da sua implementação para receber tipo inteiros long (em java).
*/

public class App4
{
    private static long iterationCount = 0;
    public static void main( String[] args )
    {
        long result;
        long x;
        long y;
        long n;
        long startTime;
        long endTime;
        
        x = 0b0011;
        y = 0b0111;
        n = 4;
        startTime = System.currentTimeMillis();
        result = multiply(x, y, n);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 4: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 4: " + iterationCount);

        iterationCount = 0;

        x = 0b0101010111110101;
        y = 0b1100110000000000;
        n = 16;
        startTime = System.currentTimeMillis();
        result = multiply(x, y, n);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 16: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 16: " + iterationCount);

        iterationCount = 0;

        x = 0b1010101111101001100110101011111010101010101110011001010101111101L;
        y = 0b0101010111001100000000001111010101010101111100110000000000110101L;
        n = 64;
        startTime = System.currentTimeMillis();
        result = multiply(x, y, n);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + result);
        System.out.println("Time taken for size 64: " + (endTime - startTime) + " ms");
        System.out.println("Iterations for size 64: " + iterationCount);
    }

public static long multiply(long x, long y, long n) {
    iterationCount++;

    if (n == 1) {
        return x * y;
    }
    else {
        long m = n/2;
        long a = (long)(x/Math.pow(2, m));
        long b = (long)(x % Math.pow(2, m));
        long c = (long)(y/Math.pow(2, m));
        long d = (long)(y % Math.pow(2, m));
        long e = multiply(a ,c , m);
        long f = multiply(b, d, m);
        long g = multiply(b, c, m);
        long h = multiply(a, d, m);
        return (long)(Math.pow(2, 2 * m) * e + Math.pow(2, m) * (g + h) + f);
    }      
}
}