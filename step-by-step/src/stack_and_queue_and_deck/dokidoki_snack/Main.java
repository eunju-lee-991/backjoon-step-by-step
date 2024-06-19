package stack_and_queue_and_deck.dokidoki_snack;

import java.io.*;
import java.util.Stack;

// 12789 도키도키 간식드리미
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();


        br.close();

        bw.flush();
        bw.close();
    }
}
