package time_complexity.algorithm_execution_time_3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();
        // int 아니고 long으로 형변환!!!!!
        bw.write((long)Math.pow(N, 2) + "\n" + "2");
        bw.flush();
        bw.close();
    }
}
