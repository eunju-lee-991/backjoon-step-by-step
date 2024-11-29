package back_tracking.sudoku;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2580 - 스도쿠
public class Main {
    static BufferedWriter bw;
    static int[][] board = new int[9][9];
    static List<int[]> blankPositions;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        blankPositions = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blankPositions.add(new int[]{i, j});
                }
            }
        }
        check(0);

        bw.flush();
        bw.close();
    }

    static void check(int index) throws IOException {
        if (index >= blankPositions.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i][j] + " ");
                }
                if (i < 8) bw.write("\n");
            }
            flag = true;
            return;
        }

        int[] pos = blankPositions.get(index);
        for (int k = 1; k <= 9; k++) {
            if (isValid(index, k)) {
                board[pos[0]][pos[1]] = k;
                check(index + 1);
            }
            if (flag) {
                return;
            }
        }
        board[pos[0]][pos[1]] = 0;
    }

    static boolean isValid(int index, int k) {
        int[] pos = blankPositions.get(index);
        int i = pos[0];
        int j = pos[1];

        // 가로줄
        for (int n : board[i]) {
            if (n == k) return false;
        }

        // 세로줄
        for (int l = 0; l < 9; l++) {
            if (board[l][j] == k) return false;
        }

        // 사각형
        int i_start = (i / 3) * 3;
        int j_start = (j / 3) * 3;
        for (int l = i_start; l < i_start + 3; l++) {
            for (int m = j_start; m < j_start + 3; m++) {
                if (board[l][m] == k) return false;
            }
        }

        // pass
        return true;
    }
}
