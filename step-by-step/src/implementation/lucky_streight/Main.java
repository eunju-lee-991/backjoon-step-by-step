package implementation.lucky_streight;
import java.io.*;

// 18406 - 럭키 스트레이트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int left = 0;
        int right = 0;

        for (int i = 0; i < input.length() / 2; i++) {
            left += Integer.parseInt(input.substring(i, i + 1));
        }

        for (int i = input.length() / 2; i < input.length(); i++) {
            right += Integer.parseInt(input.substring(i, i + 1));
        }

        if (left == right) {
            bw.write("LUCKY");
        } else {
            bw.write("READY");
        }

        bw.flush();
        bw.close();
    }
}
