package binary_search.number_card_2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 10816 - 숫자 카드 2
public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Map.Entry<Integer, Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tokenizer.nextToken());
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(tokenizer.nextToken());
            if(map.containsKey(m)){
                bw.write(String.valueOf(map.get(m)));
            } else {
                bw.write(String.valueOf(0));
            }
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}