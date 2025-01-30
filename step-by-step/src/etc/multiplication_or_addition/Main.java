package etc.multiplication_or_addition;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            int n = S.charAt(i) - '0';
            if (n > 1 && sum >1) {
                sum *= n;
            } else {
                sum += n;
            }
        }
        bw.write(sum + "");
        bw.close();
    }
}
