package dynamic_programming.longest_common_subsequence;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9251 - LCS
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] stringA = br.readLine().split("");
        String[] stringB = br.readLine().split("");
        br.close();
        int[][] dp = new int[stringA.length+1][stringB.length+1];
        int max = 0;

        for (int i = 1; i < stringA.length+1; i++) {
            for (int j = 1; j < stringB.length+1; j++) {
                if(stringA[i-1].equals(stringB[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
