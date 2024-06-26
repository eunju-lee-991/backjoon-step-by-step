package dynamic_programming.fibonacci_number_one;

import java.io.*;

// 24416 알고리즘 수업 - 피보나치 수 1
public class Main {
    static int[] arr;
    static int countR;
    static int countD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        arr = new int[n + 1];
        countR = 1;
        countD = 0;

        fibonacciRecursively(n);

        for (int i = 1; i < n + 1; i++) {
            fibonacciDynamically(i);
        }
        bw.write(countR + " "  + countD);
        bw.flush();
        bw.close();
    }

    static int fibonacciRecursively(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            countR++;
            return fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
        }
    }

    static int fibonacciDynamically(int n) {
        if (n == 1 || n == 2) {
            arr[n] = 1;
            return arr[n];
        } else if (arr[n] != 0) {
            return arr[n];
        } else {
            countD++;
            arr[n] = arr[n - 1] + arr[n - 2];
            return arr[n];
        }
    }
}
