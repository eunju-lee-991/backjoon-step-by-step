package graph_and_traverse.movement_of_knight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7562 - 나이트의 이동
public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2};
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] arr = new int[l][l];
            boolean[][] visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{cx, cy});
            visited[cx][cy] = true;
            int depth = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j <size; j++) {

                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    if (x == tx && y == ty) {
                        bw.write(depth+"\n");
                        break;
                    }
                    for (int k = 0; k < dx.length; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k % 4];
                        if (nx >= 0 && ny >= 00 && nx < l && ny < l && !visited[nx][ny]) {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                depth++;
            }

        }


        br.close();

        bw.flush();
        bw.close();
    }
}
