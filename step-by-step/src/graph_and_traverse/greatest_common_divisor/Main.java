package graph_and_traverse.greatest_common_divisor;

public class Main {
    public static void main(String[] args) {
        int A = 192;
        int B = 162;
        System.out.println(getGCD(A, B));
    }

    static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        else {
            return getGCD(b, a % b);
        }
    }
}
