package priority_queue.absolute_value_heap;

import java.io.*;
import java.util.PriorityQueue;

// 11286 - 절댓값 힙
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b) );
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                pq.add(n);
            } else {
                int result = pq.isEmpty() ? 0 : pq.poll();
                bw.write(result + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}