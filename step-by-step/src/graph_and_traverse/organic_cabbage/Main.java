package graph_and_traverse.organic_cabbage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 1012 - 유기농 배추
public class Main {
    static BufferedWriter bw ;
    static int[][] farm;
    static int count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 위치의 개수
            farm = new int[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {

                    if (farm[j][k] == 1) {
                        count++;
                        dfs(j, k);
                    }

                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        if (isValid(x, y) && farm[x][y] == 1) {
            farm[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
        }
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= farm.length || y < 0 || y >= farm[0].length) {
            return false;
        }
        return true;
    }
}