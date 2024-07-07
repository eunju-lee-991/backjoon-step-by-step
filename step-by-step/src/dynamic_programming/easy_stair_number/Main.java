package dynamic_programming.easy_stair_number;

import java.io.*;
import java.util.StringTokenizer;

// 10844 - 쉬운 계단 수
public class Main {
    static int[][] answers;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        br.close();
        int n = Integer.parseInt(tokenizer.nextToken());
        answers = new int[n+1][10];

        for (int i = 1; i < 10; i++) {
            answers[1][i] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    answers[i][j] = answers[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    answers[i][j] = answers[i - 1][j - 1] % 1000000000;
                } else {
                    answers[i][j] = (answers[i - 1][j - 1] + answers[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<=9; i++) {
            answer = (answer + answers[n][i]) % 1000000000;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}