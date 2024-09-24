package cumulative_sum.human_computer_interaction;

import java.io.*;
import java.util.StringTokenizer;

// 16139 - 인간-컴퓨터 상호작용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        String S = br.readLine();
        int[][] arr = new int[27][S.length() + 1];
        for (int i = 1; i < arr[0].length; i++) {
            for (int j = 1; j < arr.length; j++) {
                arr[j][i] = arr[j][i - 1];
            }
            int alphabet = S.charAt(i - 1) - 'a';
            arr[alphabet + 1][i]++;
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            char alphabet = tokenizer.nextToken().charAt(0);
            int l = Integer.parseInt(tokenizer.nextToken()) + 1;
            int r = Integer.parseInt(tokenizer.nextToken()) + 1;
            bw.write(String.valueOf(arr[alphabet - 'a' + 1][r] - arr[alphabet - 'a' + 1][l - 1]) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
