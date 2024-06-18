package set_and_map.number_of_different_string;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 11478 서로 다른 부분 문자열의 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j + i <= string.length(); j++) {
                set.add(string.substring(j, j + i));
            }
        }

        br.close();

        bw.write(String.valueOf(set.size()));

        bw.flush();
        bw.close();
    }
}
