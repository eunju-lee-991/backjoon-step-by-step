package two_pointer;

 import java.io.*;
        import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int i = upperBound(arr, 0, arr.length - 1, 5);
        System.out.println("!!!!!!: " +i);
    }

    static int upperBound(int[] arr, int start, int end, int k) {
        int mid = 0;
        while (start < end) {
            System.out.printf("start: %s, end: %s \n", start, end);
            mid = (start + end) / 2;
            if (arr[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println("--------------");
        System.out.printf("start: %s, end: %s \n", start, end);
        return end;
    }
}