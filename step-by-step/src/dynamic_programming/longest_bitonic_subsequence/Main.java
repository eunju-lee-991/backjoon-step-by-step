package dynamic_programming.longest_bitonic_subsequence;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11054 - 가장 긴 바이토닉 부분 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        int[] dp_increasing = new int[n];
        int[] dp_decreasing = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(tokenizer.nextToken());
        }
        br.close();
        dp_decreasing[n-1] = 1;

        for (int i = 0; i < n; i++) {
            dp_increasing[i] = 1;
            for (int j = 0; j < i; j++) {
                if(values[j] < values[i]){
                    dp_increasing[i] = Math.max(dp_increasing[i], dp_increasing[j] + 1);
                }
            }

            dp_decreasing[n-1-i] = 1;
            for (int j = n-1; j > n-1-i; j--) {
                if (values[j] < values[n-1-i]) {
                    dp_decreasing[n-1-i] = Math.max(dp_decreasing[n-1-i], dp_decreasing[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp_increasing[i] + dp_decreasing[i] - 1);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
