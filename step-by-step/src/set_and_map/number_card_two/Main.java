package set_and_map.number_card_two;

import java.io.*;
import java.util.*;

// 10816 숫자 카드 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(tokenizer.nextToken(), 1, Integer::sum);
        }
        n = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(map.getOrDefault(tokenizer.nextToken(), 0) + " ");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
