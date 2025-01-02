package combinatorics.factorial;

import java.io.*;

// 10872 - 팩토리얼
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int answer = 1;
        if (N > 1) {
            for (int i = 2; i <= N; i++) {
                answer *= i;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
