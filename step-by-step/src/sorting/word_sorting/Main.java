package sorting.word_sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// 1181 - 단어 정렬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        SortedSet<String> set = new TreeSet<>((a, b) -> {
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (String word : set) {
            bw.write(word);
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
