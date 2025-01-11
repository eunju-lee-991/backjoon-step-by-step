package string.make_anagram;

import java.io.*;

// 1919 - 애너그램 만들기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] alphabet = new int[2][26];
        for (int i = 0; i < 2; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                alphabet[i][input.charAt(j) - 'a']++;
            }
        }
        int delete = 0;
        for (int j = 0; j < alphabet[0].length; j++) {
            delete += Math.abs(alphabet[0][j] - alphabet[1][j]);
        }

        bw.write(delete+"");
        bw.close();
    }
}