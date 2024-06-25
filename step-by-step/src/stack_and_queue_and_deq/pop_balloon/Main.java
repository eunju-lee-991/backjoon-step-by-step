package stack_and_queue_and_deq.pop_balloon;

import java.io.*;
import java.util.StringTokenizer;

// 2346 풍선 터뜨리기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int popNext = 0;
        int popCount = 1;
        bw.write((popNext + 1) + " ");

        while (popCount < arr.length) {
            int popOrder = arr[popNext];
            arr[popNext] = 0;

            if (popOrder > 0) {
                for (int i = 0; i < popOrder; i++) {
                    int index = (i + 1 + popNext) % arr.length;

                    if (arr[index] == 0) {
                        popOrder++;
                    } else if (i == popOrder - 1) {
                        popNext = index;
                        popCount++;
                        bw.write((popNext + 1) + " ");
                    }
                }
            } else { // If the popOrder is negative
                for (int i = 0; i > popOrder; i--) {
                    int index = popNext + (i - 1) % arr.length < 0 ? arr.length + popNext + (i - 1) % arr.length : popNext + (i - 1) % arr.length;
                    if (arr[index] == 0) {
                        popOrder--;
                    } else if (i == popOrder + 1) {
                        popNext = index;
                        popCount++;
                        bw.write((popNext + 1) + " ");
                    }
                }
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}