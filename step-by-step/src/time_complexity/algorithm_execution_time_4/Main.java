package time_complexity.algorithm_execution_time_4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();
        long answer = (long) N * (N-1) / 2 ;
        bw.write(  answer+ "\n" + "2");
        bw.flush();
        bw.close();
    }
}
