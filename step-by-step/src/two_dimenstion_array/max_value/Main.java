package two_dimenstion_array.max_value;

import java.io.*;
import java.util.StringTokenizer;

// 2566 최댓값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        int max = -1;
        int row = -1;
        int column = -1;
        for (int i = 0; i < 9; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int newMax = Math.max(Integer.parseInt(tokenizer.nextToken()), max);
                if (newMax != max) {
                    max = newMax;
                    row = i + 1;
                    column = j + 1;
                }
            }
        }
        bw.write(max + "\n");
        bw.write(row + " " + column);
        bw.flush();
        bw.close();
    }
}
