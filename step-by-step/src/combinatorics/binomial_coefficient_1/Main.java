package combinatorics.binomial_coefficient_1;

import java.io.*;
import java.util.StringTokenizer;

// 11050 - 이항 계수 1
public class Main {
    static int[] factorials;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        factorials = new int[N+1];

        //    n!
        // --------
        // r!(n-r)!

        int answer = getFactorial(N) / (getFactorial(K) * getFactorial(N - K));
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int getFactorial(int n) {
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                factorials[i] = 1;
            }
            if (factorials[i] == 0) {
                factorials[i] = factorials[i-1] * i;
            }
        }
        return factorials[n];
    }
}
