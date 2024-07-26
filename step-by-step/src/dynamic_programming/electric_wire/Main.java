package dynamic_programming.electric_wire;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 2565 - 전깃줄
public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] dp = new int[n];
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tokenizer.nextToken());
            arr[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        br.close();
        Arrays.sort(arr, Comparator.comparingInt(v -> v[0]));

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][1] < arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        bw.write(String.valueOf(n - Arrays.stream(dp).max().getAsInt()));
        bw.flush();
        bw.close();
    }

}