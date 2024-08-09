package cumulative_sum.sum_of_remainder;

import java.io.*;
import java.util.StringTokenizer;

// 10986 - 나머지 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[] nums = new int[N + 1];
        int[] sums = new int[N + 1];
        int count = 0;

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tokenizer.nextToken());
            nums[i+1] = n;
            sums[i+1] = sums[i] + n;

            if(n % K == 0) count++;
        }
        br.close();

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N - i + 1; j++) {
                int a = sums[j+i] - sums[j-1];
                if(a % K == 0) count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
