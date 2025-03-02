package dynamic_programming.make_it_1;

public class Main {
    public static void main(String[] args) {
        int X = 26;
        int[] dp = new int[X + 1];

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[X]);
    }
}
