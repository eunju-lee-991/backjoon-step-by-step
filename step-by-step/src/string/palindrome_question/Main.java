package string.palindrome_question;

import java.io.*;
import java.util.StringTokenizer;

// 10942 - 팰린드롬?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N+1];
        boolean[][] isPalindrome = new boolean[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            isPalindrome[i][i] = true;
            if(nums[i-1] == nums[i]) isPalindrome[i-1][i] = true;
        }
        for (int i = 2; i < N; i++) { // 간격
            for (int j = 1; j + i < N + 1; j++) {
                isPalindrome[j][j+i] = isPalindrome[j+1][j+i-1] && nums[j] == nums[j+i];
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(isPalindrome[start][end] ? "1\n" : "0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean checkItIsPalindrome(int start, int end, int[] nums) {
        boolean isPalindrome = true;
        for (int i = 0; i < (end-start+1)/2; i++) {
            if (nums[start+i] != nums[end - i]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}