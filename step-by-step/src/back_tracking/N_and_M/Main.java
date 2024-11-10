package back_tracking.N_and_M;

import java.io.*;
import java.util.StringTokenizer;

// 15649 - N과 M (1)
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[N ];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        boolean[] visited = new boolean[arr.length];
        int[] output = new int[M];
        permutation(arr, visited, output, 0, M);
        bw.flush();
        bw.close();
    }

    static void permutation(int[] arr, boolean[] visited, int[] output, int depth, int r) throws IOException {
        if (depth == r) {
            for (int i = 0; i < output.length; i++) {
                bw.write(output[i] + " ");
            }
            bw.write( "\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                output[depth] = arr[i];
                visited[i] = true;
                permutation(arr, visited, output, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
