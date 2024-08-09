package cumulative_sum.cumulative_sum_4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 11659 - 구간 합 구하기 4
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[] sum = new int[N+1];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + Integer.parseInt(tokenizer.nextToken());
        }

        for (int k = 0; k < K; k++) {
            tokenizer = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(tokenizer.nextToken());
            int j = Integer.parseInt(tokenizer.nextToken());

            bw.write(sum[j] - sum[i-1] + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
