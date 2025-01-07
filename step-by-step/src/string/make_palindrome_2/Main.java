package string.make_palindrome_2;

import java.io.*;

// 1254 - 팰린드롬 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        br.close();
        int i = 0;
        while (i < input.length()) {
            if(isPalindrome(input.substring(i))) break;
            i++;
        }
        bw.write(String.valueOf(input.length() + i));
        bw.flush();
        bw.close();
    }

    static boolean isPalindrome(String string) {
        boolean result = true;
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    static boolean checkPalindrome(int start, int end, String string) {
        boolean result = true;
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            if (string.charAt(start + i) != string.charAt(end - i)) {
                result = false;
                break;
            }
        }
        return result;
    }
}