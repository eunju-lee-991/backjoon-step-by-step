package stack_and_queue_and_deq.deq_two;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// 28279 deq2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.startsWith("1")) {
                deque.offerFirst(input.substring(2));
            } else if (input.startsWith("2")) {
                deque.offerLast(input.substring(2));
            } else {
                String result = "";
                switch (input) {
                    case "3":
                        result = deque.pollFirst();
                        if(result == null) result = "-1";
                        break;
                    case "4":
                        result = deque.pollLast();
                        if(result == null) result = "-1";
                        break;
                    case "5":
                        result = String.valueOf(deque.size());
                        break;
                    case "6":
                        result = deque.isEmpty() ? "1" : "0";
                        break;
                    case "7":
                        result = deque.peekFirst() == null ? "-1" : deque.peekFirst();
                        break;
                    case "8":
                        result = deque.peekLast() == null ? "-1" : deque.peekLast();
                        break;
                }
                bw.write(result + "\n");
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
