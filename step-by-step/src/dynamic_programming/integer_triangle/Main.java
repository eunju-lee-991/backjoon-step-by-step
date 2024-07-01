package dynamic_programming.integer_triangle;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1932 - 정수 삼각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];
        arr[0] = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    temp[j] = Integer.parseInt(tokenizer.nextToken()) + arr[0];
                } else if (j == i) {
                    temp[j] = Integer.parseInt(tokenizer.nextToken()) + arr[j-1];
                } else {
                    temp[j] = Integer.parseInt(tokenizer.nextToken()) + Math.max(arr[j - 1], arr[j]);
                }
                max = Math.max(temp[j], max);
            }
            arr = Arrays.copyOf(temp, n);
        }

        br.close();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
