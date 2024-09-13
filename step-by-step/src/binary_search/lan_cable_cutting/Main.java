package binary_search.cut_lan_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1654 - 랜선 자르기
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