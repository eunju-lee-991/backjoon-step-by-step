package back_tracking.start_and_link;

import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 14889 - 스타트와 링크
public class Main {
    static BufferedWriter bw;
    static int[][] arr;
    static int K;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        K = N / 2;
        combination(0, 0, new boolean[N]);

        bw.write(min+"");
        bw.flush();
        bw.close();
    }

    static void combination(int start, int depth, boolean[] visited) { // 조합
        if (depth == K) {
            int startTeam = 0;
            int link = 0;

            for (int i = 0; i <arr.length; i++) {
                for (int j = i+1; j < arr[0].length; j++) {
                    if(visited[i] && visited[j]){
                        startTeam += arr[i][j];
                        startTeam += arr[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(startTeam - link));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            combination(i + 1, depth + 1, visited);
            visited[i] = false;
        }
    }

}
