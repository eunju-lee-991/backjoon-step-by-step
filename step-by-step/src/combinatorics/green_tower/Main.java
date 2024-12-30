package combinatorics.green_tower;

import java.io.*;

// 24723 - 녹색거탑
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        double pow = Math.pow(2, N);

        bw.write((int) pow + "");
        bw.flush();
        bw.close();
    }
}
