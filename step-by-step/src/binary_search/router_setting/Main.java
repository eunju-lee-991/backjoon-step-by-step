package binary_search.wood_cutting;

import java.io.*;
import java.util.StringTokenizer;

// 2805 - 나무 자르기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[N];
        int end = 0;
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            end = Math.max(arr[i], end);
        }
        br.close();
        int start = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(measureCutWood(arr, mid) >= M){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();
        bw.close();
    }

    /**
     *
     * 나무 높이의 합을 계산하는 과정에서 int로는 모자람. long 타입 사용
     *
     */
    static long measureCutWood(int[] arr, int length) {
        long totalLength = 0;
        for (int l : arr) {
            if(l - length > 0) totalLength += (l - length);
        }
        return totalLength;
    }
}