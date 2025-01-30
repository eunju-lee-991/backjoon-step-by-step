package tree.traversal_of_tree;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 2263 - 트리의 순회
public class Main {
    static BufferedWriter bw;
    static int[] inOrder;
    static int[] inOrderIndex;
    static int[] postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        inOrder = new int[N];
        postOrder = new int[N];
        inOrderIndex = new int[N + 1];
        StringTokenizer inOrder_st = new StringTokenizer(br.readLine());
        StringTokenizer postOrder_st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(inOrder_st.nextToken());
            inOrderIndex[inOrder[i]] = i;
            postOrder[i] = Integer.parseInt(postOrder_st.nextToken());
        }
        getPreOrder(0, N-1, 0, N-1);
        bw.close();
    }

    static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if (inStart > inEnd || postStart > postEnd)
            return;

        int root = postOrder[postEnd];
        int rootIndexInInOrder = inOrderIndex[root];
        bw.write(root+" ");
        int leftSize = rootIndexInInOrder - inStart;
        int rightSize = inEnd - rootIndexInInOrder;

        /**
         *
         * 오 왼 사이즈 (길이) 구하는 거랑 inorder postorder start end 다시 정해줄 때 주의하기!!
         */

        getPreOrder(inStart, rootIndexInInOrder - 1, postStart, postStart + leftSize - 1);
        getPreOrder(rootIndexInInOrder + 1, inEnd, postStart + leftSize, postEnd - 1);

    }
}
