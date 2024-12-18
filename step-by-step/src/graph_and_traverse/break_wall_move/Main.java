package graph_and_traverse.break_wall_move;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2206 - 벽 부수고 이동하기
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static BufferedWriter bw;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        br.close();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 좌표와 벽을 부술 수 있는 개수(기회)
        visited[0][0][1] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int chance = poll[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny)) {
                    // 다음 위치가 0이면 현재 chance에 해당하는 visited 배열의 그 위치의 방문 여부를 확인한다.
                    if (map[nx][ny] == 0 && visited[nx][ny][chance] == 0) {

                        // 현재 chance에 해당하는 visited 배열에 거리 + 1을 한 후 큐에 넣는다.
                        queue.offer(new int[] {nx, ny, chance});
                        visited[nx][ny][chance] = visited[x][y][chance] + 1;

                        // 다음 위치가 1이면 chance가 0인 경우(벽을 부순 상태)의 방문 배열을 확인한다.
                    } else if (map[nx][ny] == 1 && visited[nx][ny][0] == 0) {
                        // 기회가 남아 있으면
                        if (chance == 1) {
                            // 다음 위치에 해당하는 벽을 부순 경우의 방문 배열 = 현재 방문 배열의 거리 + 1
                            visited[nx][ny][0] = visited[x][y][1] + 1;
                            queue.offer(new int[] {nx, ny, 0});
                        }
                    }
                }
            }
        }
        // 방문배열 마지막이 둘 다 0이면 도달하지 못한 것이니 -1 =>
        // 둘 중 하나가 0인 경우에는 0이 아닌 것이 최종 거리 =>
        // 둘 다 0이 아닌 경우에는 둘 중 더 작은 것이 최단 거리
        int result = visited[N-1][M-1][0] == 0 && visited[N-1][M-1][1] == 0 ? -1 :
                visited[N-1][M-1][0] == 0 ? visited[N-1][M-1][1] :
                        visited[N-1][M-1][1] == 0 ? visited[N-1][M-1][0] :
                                Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
