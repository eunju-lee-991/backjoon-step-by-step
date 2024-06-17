package set_and_map.people_in_company;

import java.io.*;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        SortedSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String name = tokenizer.nextToken();
            String state = tokenizer.nextToken();
            if (state.equals("enter")) {
                set.add(name);
            }else {
                set.remove(name);
            }
        }
        br.close();

        for (String s : set) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}
