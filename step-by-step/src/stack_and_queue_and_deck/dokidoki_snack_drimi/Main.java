package stack_and_queue_and_deck.dokidoki_snack_drimi;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 12789 도키도키 간식드리미
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String result = "Nice";
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int order = 1;
        int i = 0;
        while (order < n) {
            stack.push(line[i++]);
            while (!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            }
            if(stack.size() > 1 && stack.peek() > stack.elementAt(stack.size() - 2)) {
                result = "Sad";
                break;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
