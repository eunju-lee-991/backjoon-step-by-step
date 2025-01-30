package etc.adventurer_guild;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int countOfGroup = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (++count >= arr[i]) {
                countOfGroup++;
                count = 0;
            }
        }
        bw.write(countOfGroup + "");
        bw.close();
    }
}
