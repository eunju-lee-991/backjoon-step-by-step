package two_pointer.partial_sum;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1806 - 부분합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[N+1];
        int[] sumArr = new int[N+1];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(tokenizer.nextToken());
            sumArr[i+1] = sumArr[i] + arr[i+1];
        }

        int i = 1;
        int j = 1;
        int length = Integer.MAX_VALUE;
        while (j < arr.length) {
            int sum = sumArr[j] - sumArr[i-1];
            if (sum >= S) {
                int gap = j - i +1;
                length = Math.min(length, gap);
                i++;
            } else {
                j++;
            }
        }

        bw.write((length == Integer.MAX_VALUE ? 0 : length )+"");
        bw.flush();
        bw.close();
    }
}
