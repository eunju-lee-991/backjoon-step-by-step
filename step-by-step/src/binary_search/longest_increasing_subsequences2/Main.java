package binary_search.longest_increasing_subsequences2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 12015 - 가장 긴 증가하는 부분 수열2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] lis = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        br.close();
        lis[0] = arr[0];
        int lastIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lis[lastIndex]) {
                lis[++lastIndex] = arr[i];
            } else {
                int index = binarySearch(lis, lastIndex, arr[i]);
                lis[index] = arr[i];
            }
        }

        bw.write(String.valueOf(++lastIndex));
        bw.flush();
        bw.close();
    }

    static int binarySearch(int[] arr, int end, int target) {
        int start = 0;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}