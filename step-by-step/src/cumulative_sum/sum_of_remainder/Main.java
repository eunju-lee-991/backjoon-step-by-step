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
        int sum = 0;
        int[] M = new int[K];
        long count = 0;

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tokenizer.nextToken());
            sum += n;
            sum %= K;
            count += M[sum];
            M[sum]++;

            if(sum == 0) count++;
        }
        br.close();

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
