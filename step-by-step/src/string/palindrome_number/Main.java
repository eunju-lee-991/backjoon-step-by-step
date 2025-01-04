package string.palindrome_number;

import java.io.*;

// 1259 - 팰린드롬 수
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String input = br.readLine();

        while (!input.equals("0")) {
            String answer = "yes";
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    answer = "no";
                    break;
                }
            }
            bw.write(answer+"\n");

            input = br.readLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
