package tree.tree_traversal;

import java.io.*;
import java.util.StringTokenizer;

// 1991 - 트리 순회
public class Main {

    static int[][] tree;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            int leftChild = st.nextToken().charAt(0) - 'A';
            int rightChild = st.nextToken().charAt(0) - 'A';

            tree[node][0] = leftChild >= 0 && leftChild < tree.length ? leftChild : -1;
            tree[node][1] = rightChild >= 0 && rightChild < tree.length ? rightChild : -1;
        }

        int start = 0;
        dfs(start);
        bw.write("\n");
        dfs_left(start);
        bw.write("\n");
        dfs_right(start);

        bw.close();
    }

    static void dfs(int index) throws IOException {
        bw.write(Character.toString(index + 'A'));
        int[] child = tree[index];
        if (child[0] > -1) {
            dfs(child[0]);
        }
        if (child[1] > -1) {
            dfs(child[1]);
        }
    }

    static void dfs_left(int index) throws IOException {
        int[] child = tree[index];
        if (child[0] > -1) {
            dfs_left(child[0]);
        }
        bw.write(Character.toString(index + 'A'));
        if (child[1] > -1) {
            dfs_left(child[1]);
        }
    }

    static void dfs_right(int index) throws IOException {
        int[] child = tree[index];
        if (child[0] > -1) {
            dfs_right(child[0]);
        }
        if (child[1] > -1) {
            dfs_right(child[1]);
        }
        bw.write(Character.toString(index + 'A'));
    }
}

