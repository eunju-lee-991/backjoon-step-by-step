package graph_and_traverse.dfs_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 24480 - 깊이 우선 탐색 2
public class Main {
    static int depth;
    static int[] visited;
    static List<SortedSet<Integer>> nodes;
    static BufferedWriter bw ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            nodes.add(new TreeSet<>(Collections.reverseOrder()));
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        visited = new int[nodes.size()];
        depth = 1;
        dfs(R);
        for (int i=1; i<visited.length; i++) {
            bw.write(visited[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int i) {
        visited[i] = depth;
        for (int node : nodes.get(i)) {
            if(visited[node]==0){
                depth++;
                dfs(node);
            }
        }
    }
}