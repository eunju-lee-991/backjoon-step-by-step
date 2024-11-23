package graph_and_traverse.bfs_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 24445 - 너비 우선 탐색 2

public class Main {
    static BufferedWriter bw ;
    static int depth = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] visited = new int[N + 1];

        List<TreeSet<Integer>> nodes = new ArrayList<>();
        nodes.add(new TreeSet<>());
        for (int i = 0; i < N; i++) {
            nodes.add(new TreeSet<>((a, b) -> b - a));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[R] = depth++;
        for (int node : nodes.get(R)) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(visited[poll] == 0) {
                visited[poll] = depth++;
                for (int node : nodes.get(poll)) {
                    queue.add(node);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            bw.write( visited[i]+"\n");
        }

        bw.flush();
        bw.close();
    }
}