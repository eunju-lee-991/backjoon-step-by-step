package two_dimenstion_array.vertical_reading;

import java.io.*;

// 10798 세로읽기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] arr = new String[5][15];
        for (int i = 0; i < arr.length; i++) {
            String[] readLine = br.readLine().split("");
            int j = 0;
            for (String s : readLine) {
                arr[i][j++] = s;
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j][i] != null)
                    bw.write(arr[j][i]);
            }
        }
        bw.flush();
        bw.close();
    }
}
