package greedy.gas_station;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 13305 - 주유소
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long totalPrice = 0;
        int N = Integer.parseInt(br.readLine());
        int[] distances = new int[N - 1];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] prices = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(tokenizer.nextToken());
        }
        br.close();

        int min = prices[0];
        totalPrice += (long) min * distances[0];

        for (int i = 1; i < distances.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            totalPrice += (long) min * distances[i];
        }

        bw.write(String.valueOf(totalPrice));
        bw.flush();
        bw.close();
    }
}
