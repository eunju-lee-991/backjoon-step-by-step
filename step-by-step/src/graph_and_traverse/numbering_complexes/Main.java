package graph_and_traverse.numbering_complexes;

import jdk.jshell.execution.Util;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 2667 - 단지번호붙이기
public class Main {
    static BufferedWriter bw ;
    static int count = 0;
    static int[][] houses;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        for (int i = 0; i < N; i++) {
            houses[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> houseCount = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < houses[0].length; j++) {
                if (houses[i][j] > 0) {
                    int dfs = dfs(i, j);
//                    System.out.println(dfs);
                    total++;
                    houseCount.add(count);
                    count = 0;
                }
            }
        }

        // 총 단지수 먼저, 단지내 집의 수 오름차 순

        bw.write(total+"\n");
        Collections.sort(houseCount);
        for (int c : houseCount) {
            bw.write(c + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int dfs(int i, int j) {
        count++;
        houses[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            if ( isValid(i + dx[k], j + dy[k]) && houses[i + dx[k]][j + dy[k]] > 0) {
                dfs(i + dx[k], j + dy[k]);
            }
        }

        return 100;
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}