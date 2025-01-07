package string.the_most_letters;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 1371 - 가장 많은 글자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] count = new int[26];
        String input ;
        int max = -1;

        while ((input = br.readLine()) != null) {
            input = input.replace(" ", "");
            for (int i = 0; i < input.length(); i++) {
                count[input.charAt(i) - 'a']++;
                max = Math.max(max, count[input.charAt(i) - 'a']);
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                bw.write((char) (i + 'a'));
            }
        }
        bw.flush();
        bw.close();
    }
}