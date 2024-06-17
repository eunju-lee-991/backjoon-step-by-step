package set_and_map.pocketmon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        Map<String, Integer> mapA = new HashMap<>();
        Map<Integer, String> mapB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            mapA.put(readLine, i+1);
            mapB.put(i+1, readLine);
        }

        for (int i = 0; i < m; i++) {
            String readLine = br.readLine();
            if (Character.isDigit(readLine.charAt(0))) {
                bw.write(mapB.get(Integer.parseInt(readLine)) + "\n");
            }else {
                bw.write(mapA.get(readLine) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
