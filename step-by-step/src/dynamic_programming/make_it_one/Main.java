package dynamic_programming.make_it_one;

import java.io.*;

// 1463 - 1로 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        br.close();

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i-1] + 1; // 바로 전의 최소 연산 횟수에서 + 1
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1); // 3으로 나누는 연산의 횟수 1을 더하는 것
            }
        }

        bw.write(String.valueOf(arr[n]));

        bw.flush();
        bw.close();
    }
}
