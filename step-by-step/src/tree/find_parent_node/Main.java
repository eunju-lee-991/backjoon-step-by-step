package tree.find_parent_node;

import java.io.*;
import java.util.*;

// 11725 - 트리의 부모 찾기
public class Main {
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        br.close();

        int[] visited = new int[list.size()];
        visited[1] = 1;
        bfs(1, visited);
//        dfs(1, visited);

        for (int i = 2; i < visited.length; i++) {
            bw.write(visited[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int p, int[] visited) {
        for (int node : list.get(p)) {
            if(visited[node] == 0){
                visited[node] = p;
                dfs(node, visited);
            }
        }
    }

    static void bfs(int root, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int node : list.get(poll)) {
                if(visited[node] == 0){
                    visited[node] = poll;
                    queue.add(node);
                }
            }
        }
    }
}
