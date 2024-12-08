package graph_and_traverse.hide_and_seek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1697 - 숨바꼭질
public class Main {
    static BufferedWriter bw;
    static int max = 100000;
    static boolean[] visited = new boolean[max + 1]; // max값과 VISITED로 범위 좁혀주는 것 중요!

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();
        int second = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer q = queue.poll();
                if (q == K) {
                    bw.write(second + "");
                    bw.flush();
                    bw.close();
                    return;
                }

                if (q + 1 <= max && !visited[q + 1]) {
                    queue.offer(q + 1);
                    visited[q+1] = true;
                }
                if (q - 1 >= 0 && !visited[q - 1]) {
                    queue.offer(q - 1);
                    visited[q-1] = true;
                }
                if (q * 2 <= max && !visited[q * 2]) {
                    queue.offer(q * 2);
                    visited[q*2] = true;
                }
            }
            second++;
        }

    }
}
