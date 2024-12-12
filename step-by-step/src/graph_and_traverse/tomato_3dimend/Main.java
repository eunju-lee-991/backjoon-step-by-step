package graph_and_traverse.tomato_3dimend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 - 7569
public class Main {
    static BufferedWriter bw;
    static int[] dh = {1,-1,0,0,0,0};
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {0,0,0,0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 높이
        int[][][] boxes = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (boxes[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }

                }
            }
        }
        br.close();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int h = poll[0];
            int x = poll[1];
            int y = poll[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M
                    && boxes[nh][nx][ny] == 0 ) {
                    queue.offer(new int[] {nh, nx, ny});
                    boxes[nh][nx][ny] = boxes[h][x][y] + 1;
                }
            }
        }

        int result = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (boxes[i][j][k] == 0) {
                        bw.write("-1");
                        bw.flush();
                        bw.close();
                        return;
                    }
                    result = Math.max(result, boxes[i][j][k]);
                }
            }
        }
        bw.write(result-1 + "");
        bw.flush();
        bw.close();
    }
}
