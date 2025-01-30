package etc.until_it_becomes_one;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int count = 0;
        while (N >= K) {
            int target = (N / K) * K;
            count += N - target;
            N /= K;
            count++;
        }
        bw.write((count + N - 1) + "");
        bw.close();
    }
}
