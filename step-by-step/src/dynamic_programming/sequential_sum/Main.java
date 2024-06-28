package dynamic_programming.sequential_sum;

import java.io.*;
import java.util.StringTokenizer;

// 1912 - 연속합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        br.close();

        int max = Integer.parseInt(tokenizer.nextToken());
        int sum = max;
        for (int i = 1; i < n; i++) {
            int input = Integer.parseInt(tokenizer.nextToken());
            sum = Math.max(input, sum + input);
            max = Math.max(sum, max);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

}
