package etc.freeze_icecream;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * 입력예시
4 5
00110
00011
11111
00000
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                    arr[i][j] = input.charAt(j) - '0';

            }
        }
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (dfs(arr, i, j)) {
                    System.out.printf("i : %s, j: %s", i, j);
                    System.out.println();
                    count++;
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    static boolean dfs(int[][] arr, int x, int y) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return false;
        }
        if (arr[x][y] == 0) {
            arr[x][y] = 1;

            dfs(arr, x - 1, y);
            dfs(arr, x, y - 1);
            dfs(arr, x + 1, y);
            dfs(arr, x, y + 1);

            return true;
        }
        return false;
    }
}
