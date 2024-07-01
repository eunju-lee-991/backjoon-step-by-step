package dynamic_programming.RGB_distance;

import java.io.*;
import java.util.StringTokenizer;

// 1149 - RGB거리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tokenizer.nextToken());
            arr[i][1] = Integer.parseInt(tokenizer.nextToken());
            arr[i][2] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i < n; i++) {
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
        }

        int answer = Math.min(arr[n-1][2], Math.min(arr[n-1][0], arr[n-1][1]));

        br.close();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
