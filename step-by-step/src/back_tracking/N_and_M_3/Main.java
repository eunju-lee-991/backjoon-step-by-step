package back_tracking.N_and_M_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 15651 - N과 M (3)
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        int[] output = new int[M];
        recursion(output, 0);

        bw.flush();
        bw.close();
    }

    static void recursion(int[] output, int depth) throws IOException {
        if (depth == output.length) {
            for (int j : output) {
                bw.write(j + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            output[depth] = i;
            recursion(output, depth + 1);
        }
    }
}
