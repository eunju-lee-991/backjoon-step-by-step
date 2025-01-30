package etc.make_it_one;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N >= 2) {
            int target = (N/3) * 3;
            if(target == 0){
                target = (N/2) * 2;
                count += N - target;
                N = target / 2;
            } else {
                count += N - target;
                N = target / 3;
            }
            count++;
        }
        bw.write((count + N - 1) + "");
        bw.close();
    }
}
