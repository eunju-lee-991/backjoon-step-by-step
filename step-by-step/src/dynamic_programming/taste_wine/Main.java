package dynamic_programming.taste_wine;

import java.io.*;

// 2156 - 포도주 시식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        sum[0] = values[0];
        if (n > 1) {
            sum[1] = values[0] + values[1];
        }
        if (n > 2) {
            sum[2] = Math.max(Math.max(values[0] + values[2], values[1] + values[2]), values[0] + values[1]);
        }
        if(n > 3){
            for (int i = 3; i < n; i++) {
                sum[i] = Math.max(Math.max(values[i] + values[i - 1] + sum[i - 3], values[i] + sum[i - 2]), sum[i - 1]);
            }
        }

        bw.write( sum[n-1] + " ");

        bw.flush();
        bw.close();
    }
}
