package implementation.UDLR;

import java.io.*;
import java.util.StringTokenizer;

// 이코테 상하좌우
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 공간의 크기

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cx = 1;
        int cy = 1;
        while (st.hasMoreTokens()) {
            int[] nextPosition = getPosition(st.nextToken(), cx, cy);
            int nx = nextPosition[0];
            int ny = nextPosition[1];
            if(nx <= 0 || ny <= 0 || nx > N || ny > N){
                continue;
            }
            cx = nx;
            cy = ny;
        }

        bw.write(cx + " " + cy);
        bw.close();
    }

    static int[] getPosition(String s, int x, int y) {
        if (s.equals("R")) {
            return new int[]{x, y+1};
        }
        if (s.equals("L")) {
            return new int[]{x, y-1};
        }
        if (s.equals("U")) {
            return new int[]{x-1, y};
        }
        // D
        return new int[]{x+1, y};
    }
}
