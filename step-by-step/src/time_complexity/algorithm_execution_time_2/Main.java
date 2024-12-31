package time_complexity.algorithm_execution_time_2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        bw.write(N + "\n" + "1");
        bw.flush();
        bw.close();

    }
}
