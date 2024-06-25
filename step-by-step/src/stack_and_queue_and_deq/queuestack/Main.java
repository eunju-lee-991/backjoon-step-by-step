package stack_and_queue_and_deq.queuestack;

import java.io.*;
import java.util.*;

// 24511 queuestack
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        StringTokenizer tokenizer2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            String value = tokenizer2.nextToken();
            if (tokenizer.nextToken().equals("0")) {
                deque.add(Integer.parseInt(value));
            }
        }

        n = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(tokenizer.nextToken());
            deque.offerFirst(input);
            bw.write(deque.pollLast() + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
