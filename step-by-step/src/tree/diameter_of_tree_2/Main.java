package tree.diameter_of_tree_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1967 - 트리의 지름
public class Main {

    static List<List<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list.get(parent).add(new int[]{child, distance});
            list.get(child).add(new int[]{parent, distance});
        }

        // dfs 넣기 전에 visited에 방문 처리 해줘야함!!!!!!!
        boolean[] visited = new boolean[list.size()];
        visited[1] = true;
        int[] fromRoot = dfs(1, 0,visited);
        visited = new boolean[list.size()];
        visited[fromRoot[0]] = true;
        int[] result = dfs(fromRoot[0], 0, visited);
        bw.write(result[1]+"");
        bw.close();
    }

    static int[] dfs(int index, int distance, boolean[] visited) {
        int maxIndex = index;
        int maxDistance = distance;

        for (int[] node : list.get(index)) {
            if(!visited[node[0]]){
                visited[node[0]] = true;
                int[] result = dfs(node[0], distance + node[1], visited);
                if (result[1] > maxDistance) {
                    maxIndex = result[0];
                    maxDistance = result[1];
                }
            }
        }

        return new int[]{maxIndex, maxDistance};
    }
}
