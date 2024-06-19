package stack_and_queue_and_deck.stack_two;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// 28278 스택 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringTokenizer tokenizer;

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String number = tokenizer.nextToken();
            String result = "";
            if(number.equals("1")){
                stack.push(tokenizer.nextToken());
            } else if (number.equals("2")){
                result = stack.isEmpty() ? "-1" : stack.pop();
                bw.write(result);
                bw.write("\n");
            } else if (number.equals("3")){
                result = String.valueOf(stack.size());
                bw.write(result);
                bw.write("\n");
            } else if (number.equals("4")){
                result = stack.isEmpty() ? "1" : "0";
                bw.write(result);
                bw.write("\n");
            } else {
                result = stack.isEmpty() ? "-1" : stack.peek();
                bw.write(result);
                bw.write("\n");
            }
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
