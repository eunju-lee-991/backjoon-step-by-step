package string.group_word_checker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 1316 - 그룹 단어 체커
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            count += isGroupWord(input);
        }
        br.close();
        bw.write(count + "");
        bw.close();
    }

    static int isGroupWord(String string) {
        List<Character> list = new ArrayList<>();
        list.add(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) != string.charAt(i)) {
                if (list.contains(string.charAt(i))) {
                    return 0;
                } else {
                    list.add(string.charAt(i));
                }
            }
        }
        return 1;
    }
}