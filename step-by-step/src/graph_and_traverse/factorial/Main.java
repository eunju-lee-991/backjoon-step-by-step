package graph_and_traverse.factorial;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorialIterative(n));
        System.out.println(factorialRecursive(n));
    }

    static BigDecimal factorialIterative(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }

    static BigDecimal factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return BigDecimal.ONE;
        }
        return BigDecimal.valueOf(n).multiply(factorialRecursive(n-1));
    }
}
