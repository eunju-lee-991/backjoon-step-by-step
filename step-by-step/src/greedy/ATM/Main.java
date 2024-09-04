package greedy.ATM;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 11399 - ATM
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tokenizer.nextToken());
            arr[i+1] = n;
        }
        br.close();
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i <N+1; i++) {
            arr[i] = arr[i - 1] + arr[i];
            sum += arr[i];
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
