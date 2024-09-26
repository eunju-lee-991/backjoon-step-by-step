package binary_search.lan_cable_cutting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1654 - 랜선 자르기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        long[] arr = new long[K]; // int로는 에러 남
        long end = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            end = Math.max(arr[i], end);
        }
        br.close();
        long start = 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            if(countCutting(arr, mid) >= N){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();
        bw.close();
    }

    static long countCutting(long[] arr, long length) {
        long totalCount = 0;
        for (long l : arr) {
            totalCount += l / length;
        }
        return totalCount;
    }
}