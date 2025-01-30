package sorting.sortings;

public class Main {
    static int[] arr = {5, 7, 9, 0, 0, 9, 3, 1, 6, 2, 4, 8};
    static int[] sorted = new int[arr.length];

    public static void main(String[] args) {
//        insertionSort();
//        quickSort(0, arr.length - 1);
//        countingSort();
//        mergeSort(0, arr.length - 1);
        selectionSort();
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int mid = (end + start) / 2;
        int right = mid + 1;
        int[] temp = new int[end - start + 1];
        int idx = 0;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }
        while (right <= end) {
            temp[idx++] = arr[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }

    // 아하 이건 배열 안의 최대값을 알아야하는군
    static void countingSort() {
        int[] counts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

    static void selectionSort() {
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int iValue = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = iValue;
        }
    }

    static void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    static void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= end && arr[i] <= pivot) {
                i++;
            }
            while (j > start && arr[j] >= pivot) {
                j--;
            }
            if (i > j) {
                int temp = arr[j];
                arr[j] = arr[start];
                arr[start] = temp;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(start, j - 1);
        quickSort(j + 1, end);
    }
}
