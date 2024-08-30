package cumulative_sum.cumulative_sum_5;

import java.io.*;
import java.util.StringTokenizer;

// 11659 - 구간 합 구하기 5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); //표의 크기
        int M = Integer.parseInt(tokenizer.nextToken()); // 합을 구해야하는 횟수
        int[][] chart = new int[N+1][N+1];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int j = 0;
            while (tokenizer.hasMoreElements()) {
                chart[i+1][++j] = Integer.parseInt(tokenizer.nextToken());
                chart[i+1][j] = chart[i+1][j] + chart[i+1][j-1];
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            tokenizer = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());

            for (int j = x1; j <= x2; j++) {
                sum += chart[j][y2] - chart[j][y1-1];
            }
            bw.write(sum + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
