package graph_and_traverse.virus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 2606 - 바이러스
public class Main {
    static BufferedWriter bw ;
    static boolean[] visited;
    static List<Set<Integer>> nodes;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        nodes = new ArrayList<>();
        nodes.add(new HashSet<>());
        for (int i = 0; i < N; i++) {
            nodes.add(new HashSet<>());
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        dfs(1);
        int result = 0;
        for (int i = 2; i < visited.length; i++) {
            if(visited[i]) result++;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int node : nodes.get(i)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}