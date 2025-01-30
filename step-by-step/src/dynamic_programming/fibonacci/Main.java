package dynamic_programming.fibonacci;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        int a = 89;
        int b = 2;



//        int n = 8;
//        dp = new int[8 + 1];
//        dp[1] = 1;
//        dp[2] = 1;
//        long fibonacci = fibonacci2(50);
//        System.out.println(fibonacci);
    }

//    static int fibonacci(int n) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//
//    }


    static long fibonacci2(int n) {
        long[] arr = new long[n + 1];
        if (n == 1 || n == 2) {
            return 1;
        }
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
