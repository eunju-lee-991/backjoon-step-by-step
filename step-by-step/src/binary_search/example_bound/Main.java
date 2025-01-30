package binary_search.example_bound;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 4, 8, 9};
        countByRange(arr, 4, 4);
        countByRange(arr, -1, 3);
    }

    static void countByRange(int[] arr, int start, int end) {
        int l = lowerBound(arr, start);
        int u = upperBound(arr, end);
        System.out.println( u-l);
    }

    // 찾고자 하는 값 이상이 처음 나타나는 위치
    static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start +  end) / 2;
            if (arr[mid] < target ) {
                start = mid + 1;
            } else { // arr[mid] >= target
                end = mid;
            }
        }
        return end;
    }

    // 찾고자 하는 값보다 큰 값이 처음 나타나는 위치
    static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start +  end) / 2;
            if (arr[mid] <= target ) {
                start = mid + 1;
            } else { // arr[mid] > target
                end = mid;
            }
        }
        return end;
    }
}
