package stack_and_queue_and_deq.pop_balloon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 2346 풍선 터뜨리기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        Deque<Integer> deque = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(LinkedList::new));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(tokenizer.nextToken());
        }

        int nextPop = 1;
        while (!deque.isEmpty()) {
            if (nextPop > 0) {
                for (int i = 0; i < nextPop - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                Integer poll = deque.pollFirst();
                nextPop = arr[poll];
                bw.write(poll+" ");
            }else {
                for (int i = 0; i > nextPop + 1; i--) { // 음수인 경우 고려
                    deque.offerFirst(deque.pollLast());
                }
                Integer poll = deque.pollLast();
                nextPop = arr[poll];
                bw.write(poll+" ");
            }

        }

        br.close();

        bw.flush();
        bw.close();
    }
}