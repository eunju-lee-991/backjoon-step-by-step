package string.anagram;

import java.io.*;

// 6443 - 애나그램
public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] alphabet = new int[26];
            String input = br.readLine();

            // 알파벳 개수 카운트
            for (int j = 0; j < input.length(); j++) {
                alphabet[input.charAt(j) - 'a']++;
            }

            char[] result = new char[input.length()];
            perm(alphabet, result, 0, input.length());

        }
        bw.close();
    }

    static void perm(int[] alphabet, char[] result, int r, int count) throws IOException {
        if (r == count) {
            bw.write(String.valueOf(result));
            bw.write("\n");
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                alphabet[i]--;
                result[r] = (char)( i+'a');
                perm(alphabet, result, r+1, count);
                alphabet[i]++;
            }
        }
    }
}
