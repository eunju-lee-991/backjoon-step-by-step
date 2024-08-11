package cumulative_sum.sequence;

import java.io.*;
import java.util.StringTokenizer;

// 2559 -수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int days = Integer.parseInt(tokenizer.nextToken());
        int[] nums = new int[N];
        int[] sum = new int[N - days + 1];

        tokenizer = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
            if(i < days) sum[0] += nums[i];
        }

        int max = sum[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i + days - 1] - nums[i - 1];
            max = Math.max(max, sum[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
