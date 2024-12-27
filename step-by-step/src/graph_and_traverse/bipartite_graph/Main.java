package graph_and_traverse.bipartite_graph;

import java.io.*;
import java.util.*;

// 1707 - 이분 그래프(Bipartite Graph)
public class Main {
    static int[] visited;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            isBipartite = true;
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점
            int E = Integer.parseInt(st.nextToken()); // 간선
            List<List<Integer>> vertexes = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                vertexes.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                vertexes.get(u).add(v);
                vertexes.get(v).add(u);
            }
            bw.write(isBipartiteGraph(vertexes) ? "YES" : "NO");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean isBipartiteGraph(List<List<Integer>> graph) {
        visited = new int[graph.size()];
        boolean result = false;
//        return bfs(graph);
        for (int i = 1; i < graph.size(); i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                result = dfs(graph, i);
                if(!result){
                    return result;
                }
            }
        }

        return result;
    }


    static boolean bfs(List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();

        for (int k = 1; k < graph.size(); k++) {
            if (visited[k] == 0) {
                queue.add(k);
                visited[k] = 1;
            }
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                int currentGroup = visited[vertex];
                int oppositeGroupIndex = currentGroup * -1;

                for (int i : graph.get(vertex)) {
                    if (visited[i] != 0) {
                        // i들이 같은 그룹에 없어야함! 같은 그룹에 있는지 확인
                        if (visited[i] == currentGroup) {
                            return false;
                        }
                    } else {
                        // 다른 그룹에 넣어야함!
                        visited[i] = oppositeGroupIndex;
                        queue.add(i);
                    }
                }
            }
        }

        return true;
    }


    static boolean dfs(List<List<Integer>> graph, int index) {
        int currentGroup = visited[index];
        int opposite = currentGroup * -1;

        for (int v : graph.get(index)) {
            if (visited[v] != 0) {
                if (visited[v] == currentGroup) {
                    return false;
                }
            } else {
                visited[v] = opposite;
                if (!dfs(graph, v)) {
                    return false;
                }
            }
        }
        return true;
    }
}
