package binary_search.ttoppokki;

public class Main {
    public static void main(String[] args) {
        int N = 4;
        int M = 6;
        int[] arr = {19, 15, 10, 17};

        System.out.println(upperBound(arr, 0, 19, M));
    }

    static int upperBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (right + left) / 2;
            if (cutResult(mid, arr) <= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    static int cutResult(int mid, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += Math.max(a - mid, 0);
        }
        return sum;
    }
}
