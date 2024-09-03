package greedy.assign_meeting_room;

import java.io.*;
import java.util.*;

// 1931 - 회의실 배정
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            arr[i][0] = n;
            arr[i][1] = m;
        }
        /**
         * 회의 종료 시간이 같으면
         * 회의 시작 시간 순으로 정렬!!!!
         */
        Arrays.sort(arr, (a, b) -> a[1] > b[1] ? 1 : a[1] == b[1] ? a[0] - b[0] : -1);
        br.close();

        int end = arr[0][1];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
