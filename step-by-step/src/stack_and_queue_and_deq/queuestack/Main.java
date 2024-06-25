package stack_and_queue_and_deq.queuestack;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 24511 queuestack
public class Main {
    static int[] dataStructures;
    static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dataStructures = new int[n];
        data = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dataStructures[i] = Integer.parseInt(tokenizer.nextToken());
        } // 자료구조 담기

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(tokenizer.nextToken());
        } // 자료구조 초기값 담기

        n = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < dataStructures.length; j++) {
                if (dataStructures[j] == 0) { // queue
                    int temp = data[j];
                    data[j] = input;
                    input = temp;
                }
            }
            bw.write(input + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }

}
