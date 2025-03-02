package dynamic_programming.money_composition;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[] arr = new int[n];
        int[] dp = new int[m + 1];
        arr[0] = 3;
        arr[1] = 5;
        arr[2] = 7;

        for (int i = 0; i < arr.length; i++) {
            int money = arr[i];
            if (money > m) {
                break;
            }
            dp[money] = 1;
            for (int j = money+1; j <= m; j++) {
                if (dp[j - money] > 0) {
                    dp[j] = dp[j - money] + 1;
                }
            }
        }
        if (dp[m] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }

//        for (int i = 1; i <= m; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if(i == arr[j]){
//                    dp[i] = 1;
//                } else if (i - arr[j] > 0) {
//                    if (dp[i - arr[j]] > 0) {
//                        dp[i] = dp[i - arr[j]] + 1;
//                    }
//                }
//            }
//        }
//        if (dp[m] == 0) {
//            System.out.println(-1);
//        } else {
//            System.out.println(dp[m]);
//        }
    }
}
