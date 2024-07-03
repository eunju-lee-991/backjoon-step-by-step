package dynamic_programming.make_it_one;

import java.io.*;

// 1463 - 1로 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int count = 0;
        if (n == 1) {
            count = 1;
        }

        while (n > 1) {

            count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
