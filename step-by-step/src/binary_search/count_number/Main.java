package binary_search.count_number;

public class Main {
    public static void main(String[] args) {
        int x = 1;
        int[] arr = {1, 1, 2, 2, 2, 2, 3, 4,5,5,5};
        int startIndex = lowerBound(arr, x);
        int endIndex = upperBound(arr, x);

        System.out.println(endIndex - startIndex);
    }

    static int lowerBound(int[] arr, int x) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    static int upperBound(int[] arr, int x) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
