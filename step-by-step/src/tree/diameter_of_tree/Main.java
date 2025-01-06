package tree.diameter_of_tree;

import java.io.*;
import java.util.*;

// 1167 - 트리의 지름
public class Main {
    static List<List<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int n;
            int distance;
            while (true) {
                n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }
                distance = Integer.parseInt(st.nextToken());
                list.get(node).add(new int[]{n, distance});
            }
        }
        br.close();

        boolean[] visited = new boolean[list.size()];
        visited[1] = true;
        int[] fromRoot = dfs(1, visited, 0);
        visited = new boolean[list.size()];
        visited[fromRoot[1]] = true;
        int[] farthest = dfs(fromRoot[1], visited, 0);

        bw.write(farthest[0] + "");
        bw.flush();
        bw.close();
    }

    static int[] dfs(int index, boolean[] visited, int distance) {
        int maxDistance = distance;
        int farthestNode = index;

        for (int[] node : list.get(index)) {
            if (!visited[node[0]]) {
                visited[node[0]] = true;
                int[] disAndNode = dfs(node[0], visited, distance + node[1]);
                if (disAndNode[0] > maxDistance) {
                    maxDistance = disAndNode[0];
                    farthestNode = disAndNode[1];
                }
            }
        }
        return new int[]{maxDistance, farthestNode};
    }
}
