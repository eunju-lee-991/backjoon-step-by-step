package sorting.exchange_element;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            a[j] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            b[j] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if (a[i] < b[i]) {
                a[i] = b[i];
            } else {
                break;
            }
        }
        int sum = 0;
        for (int e : a) {
            sum += e;
        }
        bw.write(sum + "");
        bw.close();
    }
}
