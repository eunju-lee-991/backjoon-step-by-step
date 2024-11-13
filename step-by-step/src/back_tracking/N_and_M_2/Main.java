package back_tracking.N_and_M_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 15650 - N과 M (2)
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
        recursion(0, 0, output);

        bw.flush();
        bw.close();
    }

    static void recursion(int start, int depth, int[] output) throws IOException {
        if (depth == M) {
            Arrays.stream(output).forEach(o -> {
                try {
                    bw.write(o + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.write("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            output[depth] = i;
            recursion(i+1, depth +1, output);
        }
    }

//    static void recursion(int[] arr, int start, int depth, int[] output) throws IOException {
//        if (depth == M) {
//            for (int i = 0; i < output.length; i++) {
//                bw.write(output[i] + " ");
//            }
//            bw.write("\n");
//            return;
//        }
//        for (int i = start; i < arr.length; i++) {
//            output[depth] = arr[i];
//            recursion(arr, i + 1, depth +1, output);
//        }
//    }
}
