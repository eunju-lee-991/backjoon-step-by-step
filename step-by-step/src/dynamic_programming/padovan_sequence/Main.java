package dynamic_programming.padovan_sequence;

import java.io.*;

// 9461 - 파도반 수열
public class Main {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            bw.write(padovan(m) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static long padovan(int m) {
        for (int i = 1; i < m + 1; i++) {
            if (arr[i] == 0) {
                if (i < 4) {
                    arr[i] = 1;
                } else {
                    arr[i] = arr[i - 2] + arr[i - 3];
                }
            }
        }
        return arr[m];
    }
}
