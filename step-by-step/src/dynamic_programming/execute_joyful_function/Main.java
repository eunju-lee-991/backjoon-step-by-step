package dynamic_programming.execute_joyful_function;

import java.io.*;
import java.util.StringTokenizer;

// 9184 - 신나는 함수 실행
public class Main {
    static Integer[][][] arr = new Integer[101][101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        while (true) {
            String input = br.readLine();
            if (input.equals("-1 -1 -1")) break;
            tokenizer = new StringTokenizer(input);
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int result = wFunction(a,b,c);

            bw.write( String.format("w(%d, %d, %d) = %d", a, b, c, result) + "\n");
//            System.out.println(String.format("w(%d, %d, %d) = %d", a, b, c, result));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int wFunction(int a, int b, int c) {
        if(arr[a+50][b+50][c+50] != null) return arr[a+50][b+50][c+50];
        if(a <= 0 || b <= 0 || c <= 0) {
            arr[a+50][b+50][c+50] = 1;
            return arr[a+50][b+50][c+50];
        } else if (a > 20 || b >20 || c >20){
            arr[a+50][b+50][c+50] = wFunction(20, 20, 20);
            return arr[a+50][b+50][c+50];
        } else if (a < b && b < c) {
            arr[a + 50][b + 50][c + 50] = wFunction(a, b, c - 1) + wFunction(a, b - 1, c - 1) - wFunction(a, b - 1, c);
            return arr[a+50][b+50][c+50];
        } else {
            arr[a + 50][b + 50][c + 50] = wFunction(a - 1, b, c) + wFunction(a - 1, b - 1, c) + wFunction(a - 1, b, c - 1) - wFunction(a - 1, b - 1, c - 1);
            return arr[a + 50][b + 50][c + 50];
        }
    }
}
