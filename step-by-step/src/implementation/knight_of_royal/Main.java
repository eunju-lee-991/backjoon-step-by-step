package implementation.knight_of_royal;

import java.io.*;

// 이코테 왕실의 나이트
public class Main {
    static int[] dx = {-1, 1, -2, -2, 2, 2, -1, 1};
    static int[] dy = {-2, -2, -1, 1, -1, 1, 2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 행 1~8 / 열 a ~ h
        String input = br.readLine();
        int column = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';
        int count = 0;

        for (int i = 0; i < dx.length; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];
            if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
                count++;
            }
        }
        bw.write(count+"");
        bw.close();
    }
}
