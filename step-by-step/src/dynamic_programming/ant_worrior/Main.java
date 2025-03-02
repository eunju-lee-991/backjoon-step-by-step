package dynamic_programming.ant_worrior;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        br.close();
        String input = "1 3 1 5";
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[arr.length];

        dp[0] = arr[0];

        if (arr.length > 1) {
            dp[1] = Math.max(arr[0], arr[1]);
        }
        if (arr.length > 2) {
            dp[2] = Math.max(dp[1], dp[0] + arr[2]);
        }

        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        bw.write(dp[dp.length-1] + "");
        bw.close();
    }
}
