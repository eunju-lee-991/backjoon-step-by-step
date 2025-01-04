package combinatorics.bridge;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 1010 - 다리 놓기
public class Main {
    static BigInteger[] factorials = new BigInteger[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            factorials = new BigInteger[M+1];

            // 결국은 M개 중에서 N개를 뽑으라는 의도의 문제임!
            BigInteger count = getFactorial(M).divide (getFactorial(N).multiply( getFactorial(M - N)));

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

    static BigInteger getFactorial(int n) {
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                factorials[i] = BigInteger.ONE;
            }
            if (factorials[i] == null) {
                factorials[i] = factorials[i-1].multiply(BigInteger.valueOf(i));
            }
        }
        return factorials[n];
    }
}
