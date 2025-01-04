package string.make_palindrome;

import java.io.*;

// 1213 - 팰린드롬 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        br.close();

        int[] arr = new int[26];
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'A']++;
        }
        boolean isEven = input.length() % 2 == 1;

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (arr[i] == 1 && isEven) {
                    // check if the middle is empty
                    if (result[result.length / 2] == '\u0000') {
                        // put in the middle
                        result[result.length / 2] = (char) ('A' + i);
                        arr[i]--;
                    } else { // 이미 가운데 값이 있는데 또 문자 하나가 남은 경우
                        bw.write("I'm Sorry Hansoo");
                        bw.flush();
                        bw.close();
                        return;
                    }
                } else if (arr[i] == 1 && !isEven) { // 짝수인데 문자 하나가 남은 경우
                    bw.write("I'm Sorry Hansoo");
                    bw.flush();
                    bw.close();
                    return;
                } else {
                    result[index] = (char) ('A' + i);
                    result[result.length - 1 - index++] = (char) ('A' + i);
                    arr[i] -= 2;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
