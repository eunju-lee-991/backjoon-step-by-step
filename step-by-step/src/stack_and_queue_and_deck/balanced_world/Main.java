package stack_and_queue_and_deck.balanced_world;

import java.io.*;
import java.util.Stack;

// 4949 균형잡힌 세상
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack;
        while (true) {
            String string = br.readLine();
            if (string.equals("."))
                break;
            stack = new Stack<>();
            String result = "yes";
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (!stack.isEmpty()) {
                        if (c == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else if (c == ']' && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            result = "no";
                            break;
                        }
                    } else {
                        result = "no";
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                result = "no";
            }
            bw.write(result + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
