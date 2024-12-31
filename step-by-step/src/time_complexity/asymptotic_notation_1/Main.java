package time_complexity.asymptotic_notation_1;

import java.io.*;
import java.util.StringTokenizer;

// 24313 - 알고리즘 수업 - 점근적 표기 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

//        for (int i = 1; i <= n0 ; i++) {
//
//            int f_result = f(i, a0, a1);
//            int cg_result = cg(i, c);
//            System.out.printf("f: %d , dg: %d, f <= cg??: %b", f_result, cg_result, f_result <= cg_result);
//            System.out.println("");
//        }

        int f_result = f(n0, a0, a1);
        int cg_result = cg(n0, c);

        bw.write(f_result <= cg_result && c >= a1 ? "1" : "0");
        bw.flush();
        bw.close();
    }

    static int f(int n, int a0, int a1) {
        return n*a1 + a0;
    }

    static int cg(int n, int c) {
        return c * n;
    }
}
