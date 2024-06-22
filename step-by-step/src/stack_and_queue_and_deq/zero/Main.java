package stack_and_queue_and_deq.zero;

import java.io.*;
import java.util.Stack;

// 10773 zero
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            if (readLine.equals("0")) {
                stack.pop();
            }else {
                stack.push(readLine);
            }
        }
        br.close();
        int sum = stack.stream().mapToInt(Integer::parseInt).sum();
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}
