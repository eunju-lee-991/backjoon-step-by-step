package stack_and_queue_and_deq.josephus;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 11866q 요세푸스 문제 0
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int order = array[1];

        Queue<Integer> queue = new LinkedList<>(IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()));

        bw.write("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < order - 1; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);
            }
            bw.write(String.valueOf(queue.poll()));
            if (queue.size() > 0) {
                bw.write(", ");
            }
        }

        br.close();
        bw.write(">");

        bw.flush();
        bw.close();
    }
}
