package back_tracking.N_QUEEN;

import java.io.*;

// 9663 - N-Queen
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int result;
    static int[] columns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        columns = new int[N];
        result = 0;

        dfs(0);

        bw.write(result +"");
        bw.flush();
        bw.close();
    }

    static void dfs(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            columns[row] = i;
            if(isValid(row)){
                dfs(row + 1);
            }
        }
    }

    private static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열 or 대각선
            if(columns[i] == columns[row] || (Math.abs(i - row) == Math.abs(columns[i] - columns[row]))) return false;
        }
        return true;
    }
}
