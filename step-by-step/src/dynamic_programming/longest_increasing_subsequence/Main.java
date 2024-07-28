package dynamic_programming.longest_increasing_subsequence;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9251 - LCS
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        int[] dp = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(tokenizer.nextToken());
        }
        br.close();
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(values[j] < values[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        bw.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));

        bw.flush();
        bw.close();
    }
}
