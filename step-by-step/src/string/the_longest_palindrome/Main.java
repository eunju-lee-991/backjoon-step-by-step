package string.the_longest_palindrome;

import java.io.*;

// 프로그래머스 - 가장 긴 팰린드롬
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("abcdcba")); // 7
        System.out.println(solution("abacde")); // 3

    }
    static int solution(String s)
    {
        int answer = 1;
        char[] chars = s.toCharArray();
        boolean[][] isPalindrome = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            isPalindrome[i][i] = true;
            if(i > 0 && chars[i-1] == chars[i]) {
                isPalindrome[i-1][i] = true;
                answer = 2;
            }
        }
        for (int i = 2; i < chars.length; i++) { // gap
            for (int j = 0; j + i < chars.length; j++) {
                isPalindrome[j][j+i] = isPalindrome[j+1][j+i-1] && chars[j] == chars[j+i];
                if(isPalindrome[j][j+i]) answer = Math.max(answer, i+1);
            }
        }

        return answer;
    }
}
