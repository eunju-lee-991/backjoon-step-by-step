package binary_search.router_setting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2110 - 공유기 설치
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);
        int end = arr[N-1]; // 최대값은 마지막 집의 좌표
        int start = 1; // 최소값은 1
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int now = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] >= now + mid) {
                    count++;
                    now = arr[i];
                }
            }

            if (count >= C) { // 설치한 공유기가 주어진 공유기 보다 많다 -> 거리 늘려야함
                start = mid + 1;
            } else { // 설치한 공유기가 주어진 공유기 보다 적다 -> 거리 줄여야함
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(end));
        bw.flush();
        bw.close();
    }

}