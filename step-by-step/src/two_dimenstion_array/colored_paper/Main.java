package two_dimenstion_array.colored_paper;

import java.io.*;
import java.util.StringTokenizer;

// 2563 색종이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[100][100];
        int breadth = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = 90 - Integer.parseInt(tokenizer.nextToken()); // 90 -> 도화지 100 - 색종이 10

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (arr[j][k] == 0) {
                        breadth++;
                        arr[j][k] = 1;
                    }
                }
            }
        }
        br.close();
        bw.write(String.valueOf(breadth));
        bw.flush();
        bw.close();
    }
}
