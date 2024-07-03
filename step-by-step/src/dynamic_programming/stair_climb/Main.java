package dynamic_programming.stair_climb;

import java.io.*;

// 2579 - 계단 오르기
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
            sum[1] = Math.max(values[1], values[0] + values[1]); // 그냥 values[0] + values[1] 해도 되지 않나??
        }
        if (n > 2) {
            sum[2] = Math.max(values[0] + values[2], values[1] + values[2]);
        }
        if(n > 3){
            for (int i = 3; i < n; i++) {
                sum[i] = Math.max(values[i] + values[i - 1] + sum[i - 3], values[i] + sum[i - 2]);
            }
        }

        bw.write( sum[n-1] + " ");

        bw.flush();
        bw.close();
    }
}
