package graph_and_traverse.dfs_and_bfs;

import java.io.*;
import java.util.*;

// 1260 - DFS와 BFS
public class Main {
    static BufferedWriter bw ;
    static boolean[] visited;
    static List<TreeSet<Integer>> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        nodes = new ArrayList<>();
        nodes.add(new TreeSet<>());
        for (int i = 0; i < N; i++) {
            nodes.add(new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            nodes.get(n).add(m);
            nodes.get(m).add(n);
        }

        dfs(V);
        visited = new boolean[N + 1];
        bw.write("\n");
        bfs(V);

        bw.flush();
        bw.close();
    }

    static void dfs(int v) throws IOException {
        visited[v] = true;
        bw.write(v + " ");
        for (int i : nodes.get(v)){
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            bw.write(poll + " ");
            for (int i : nodes.get(poll)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}