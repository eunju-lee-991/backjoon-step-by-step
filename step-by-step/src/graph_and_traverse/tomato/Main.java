package graph_and_traverse.tomato;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7576 - 토마토
public class Main {
    static BufferedWriter bw;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        int days = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        br.close();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    box[nx][ny] = box[cx][cy] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                } else {
                    days = Math.max(days, box[i][j]);
                }
            }
        }
        bw.write(days-1 + "");
        bw.flush();
        bw.close();
    }
}
