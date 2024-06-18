package set_and_map.unknown;

import java.io.*;
import java.util.*;

// 1764 듣보잡
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int unheard = Integer.parseInt(tokenizer.nextToken());
        int unread = Integer.parseInt(tokenizer.nextToken());
        SortedSet<String> unheardSet = new TreeSet<>();
        Set<String> unreadSet = new HashSet<>();
        for (int i = 0; i < unheard; i++) {
            unheardSet.add(br.readLine());
        }
        for (int i = 0; i < unread; i++) {
            unreadSet.add(br.readLine());
        }

        br.close();

        unheardSet.retainAll(unreadSet);
        bw.write(unheardSet.size() + "\n");
        for (String s : unheardSet) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
