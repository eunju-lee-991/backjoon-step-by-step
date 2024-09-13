package binary_search.find_number;

import java.io.*;
import java.util.*;

// 1920 - 수 찾기
public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(tokenizer.nextToken());
            if(binarySearch(0, arr.length - 1, m)){
                sb.append(1).append('\n');
            }else {
                sb.append(0).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static boolean binarySearch(int start, int end, int m) {
        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] == m) {
                return true;
            } else if (m < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}