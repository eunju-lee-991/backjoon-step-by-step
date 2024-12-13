package graph_and_traverse.snakes_and_ladders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16928 - 뱀과 사다리 게임
public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        int rollCount = 0;
        int[] board = new int[101];
        int[] ladders = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladders[x] = y;
        }
        int[] snakes = new int[101];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snakes[u] = v;
        }
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        board[1]++;

        while (!queue.isEmpty()) {
            int cx = queue.poll();
            if (cx == 100) {
                rollCount = board[cx];
                break; // break 까먹을 뻔
            }
            for (int i = 1; i <= 6; i++) {
                int nx = cx + i;

                if(nx <= 100) { // nx가 100 이하이면서
                    if(ladders[nx] != 0) { // 사다리의 시작인 경우
                        nx = ladders[nx];
                        ladders[cx + i] = 0; // 사다리의 시작에서 제외
                        board[cx + i] = -1; // 보드도 방문 처리
                    } else if (snakes[nx] != 0) { // 뱀의 시작인 경우
                        nx = snakes[nx];
                        snakes[cx + i] = 0; // 뱀의 시작에서 제외
                        board[cx + i] = -1; // 보드도 방문 처리
                    }
                    if(board[nx] == 0) { // 아직 방문하지 않은 칸의 경우
                        board[nx] = board[cx] + 1;
                        queue.offer(nx);
                    }
                }

            }

        }
        bw.write( rollCount-1 +"");
        bw.flush();
        bw.close();
    }
}
