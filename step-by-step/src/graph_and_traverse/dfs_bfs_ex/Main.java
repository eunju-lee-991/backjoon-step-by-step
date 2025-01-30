package graph_and_traverse.dfs_bfs_ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int o = 1;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        List<int[]> graph =
                List.of(
                        new int[]{},
                        new int[]{2, 3, 8},
                        new int[]{1, 7},
                        new int[]{1, 4, 5},
                        new int[]{3, 5},
                        new int[]{3, 4},
                        new int[]{7},
                        new int[]{2, 6, 8},
                        new int[]{1, 7}
                );
        boolean[] visited = new boolean[graph.size()];
        int start = 1;
//        dfs(start, visited, graph);


         queue = new LinkedList<>();
        int[] order = new int[graph.size()];
//        dfs_순서저장(start, visited, order, graph, 1);
//        for (int i : order) {
//            System.out.println(i);
//        }
        bfs(start, visited, order, graph);
                for (int i : order) {
            System.out.println(i);
        }
    }

    static void dfs(int index, boolean[] visited, List<int[]> graph) {
        System.out.println(index);
        visited[index] = true;
        for(int i : graph.get(index)) {
            if(!visited[i]) {
                dfs(i, visited, graph);
            }
        }
    }

    /**
     *
     * e다시보셈
     * 다세 보셈!!
     *
     */
    static int dfs_순서저장(int index, boolean[] visited, int[] order, List<int[]> graph, int currentOrder) {
        visited[index] = true;
        order[currentOrder] = index; // 현재 방문 순서를 기록
        currentOrder++; // 다음 순서로 증가
        for (int i : graph.get(index)) {
            if (!visited[i]) {
                currentOrder = dfs_순서저장(i, visited, order, graph, currentOrder);
            }
        }
        return currentOrder; // 최종 방문 순서를 반환
    }

    static void bfs(int index, boolean[] visited, int[] order, List<int[]> graph) {
        visited[index] = true;
        order[o++] = index;
        queue.add(index);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
//            System.out.println(poll);
            for (int i : graph.get(poll)) {
                if (!visited[i]) {
                    visited[i] = true;
                    order[o++] = i;
                    queue.add(i);
                }
            }
        }
    }
}
