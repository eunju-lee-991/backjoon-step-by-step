package set_and_map.difference;

import java.io.*;
import java.util.*;

// 1269 대칭 차집합 -> 합집합 - 교집합?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        Set<String> setA = new HashSet<>();

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            setA.add(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = tokenizer.nextToken();
            if(!setA.remove(s)){
                setA.add(s);
            }
        }
        br.close();

        bw.write(String.valueOf(setA.size()));

        bw.flush();
        bw.close();
    }
}
