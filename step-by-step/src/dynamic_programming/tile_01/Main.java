package dynamic_programming.tile_01;

import java.io.*;

// 1904 - 01타일
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        br.close();

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                arr[1] = 1;
            } else if (i == 2) {
                arr[2] = 2;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
                arr[i] %= 15746;
            }
        }

        bw.write(arr[n] + " ");

        bw.flush();
        bw.close();
    }
}
