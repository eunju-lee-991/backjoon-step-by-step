package two_pointer.continuous_sum_of_prime_number;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1644 - 소수의 연속합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N < 2) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        boolean[] arr = new boolean[N + 1];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i]) {
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = false;
                }
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i])
                numbers.add(i);
        }

        // 자연수 N를 연속된 소수의 합으로 나타낼 수 있는 경우의 수
        int count = 0;
        int start = 0;
        int end = 0;
        int sum = numbers.get(end);

        while (start < numbers.size()) {
            if (sum == N) {
                count++;
                sum -= numbers.get(start);
                start++;
            } else if (sum < N) {
                if (++end == numbers.size()) {
                    break;
                }
                sum += numbers.get(end);
            } else {
                sum -= numbers.get(start);
                start++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
