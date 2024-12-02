package back_tracking.insert_operator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 14888 - 연산자 끼워넣기
public class Main {
    static BufferedWriter bw;
    static int[] nums;
    static int[] operators = new int[4]; // +,-,*,/
    static int min = 1000000001;
    static int max = -1000000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 0);
        bw.write(max + "\n");
        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int sum, int depth) {
        if (depth == nums.length - 1) {
            System.out.println(sum);
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int newSum;
                if (i == 0) {
                    newSum = sum + nums[depth+1];
                } else if (i == 1) {
                    newSum = sum - nums[depth+1];
                } else if (i == 2) {
                    newSum = sum * nums[depth+1];
                } else {
                    newSum = sum / nums[depth+1];
                }
                dfs(newSum, depth+1);
                operators[i]++;
            }
        }
    }
}
