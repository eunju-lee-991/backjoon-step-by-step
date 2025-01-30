package graph_and_traverse.escape_maze;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i + 1][j + 1] = s.charAt(j) - '0';
            }
        }
        bfs(1, 1);
        bw.close();
    }

    static void bfs(int i, int j) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ci = current[0];
                int cj = current[1];
                int ni = current[0] + dx[k];
                int nj = current[1] + dy[k];
                if (ni >= 1 && nj >= 1 && ni < arr.length && nj < arr[0].length && arr[ni][nj] == 1) {
                    if (ni == arr.length - 1 && nj == arr[0].length - 1) {
                        bw.write(String.valueOf(arr[ci][cj] + 1 ));
                    }
                    arr[ni][nj] = arr[ci][cj] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
    }
}
