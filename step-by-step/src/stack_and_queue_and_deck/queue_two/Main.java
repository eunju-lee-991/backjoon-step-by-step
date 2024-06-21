package stack_and_queue_and_deck.queue_two;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 10773 zero
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        String last = "";
        for (int i = 0; i < n; i++) {
            String inst = br.readLine();
            String result = "";
            if (inst.startsWith("push")) {
                last = inst.substring(5);
                queue.offer(last);
            } else {
                switch (inst) {
                    case "pop":
                        result = queue.isEmpty() ? "-1" : queue.poll();
                        break;
                    case "size":
                        result = String.valueOf(queue.size());
                        break;
                    case "empty":
                        result = queue.isEmpty() ? "1" : "0";
                        break;
                    case "front":
                        result = queue.isEmpty() ? "-1" : queue.peek();
                        break;
                    case "back":
                        result = queue.isEmpty() ? "-1" : last;
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
