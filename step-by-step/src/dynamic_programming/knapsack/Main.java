package dynamic_programming.knapsack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12865 - 평범한 배낭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int maxWeight = Integer.parseInt(tokenizer.nextToken());
        int[][] dp = new int[maxWeight + 1][n + 1];
        int[][] vw = new int[n+1][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            vw[i+1][0] = Integer.parseInt(tokenizer.nextToken()); // 무게
            vw[i+1][1] = Integer.parseInt(tokenizer.nextToken()); // 가치
        }

        for (int i = 1; i < maxWeight+1; i++) {
            for (int j = 1; j <n+1; j++) {
                dp[i][j] = dp[i-1][j];
                int w = vw[j][0];
                int v = vw[j][1];
                if (w <= vw[i][0]) {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-w][j-1] + v);
                }
            }
        }

        br.close();
        bw.write(String.valueOf(dp[maxWeight][n]));
        bw.flush();
        bw.close();
    }
}
