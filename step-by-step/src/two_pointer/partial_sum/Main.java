package two_pointer.two_solution;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2470 두 용액
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[Integer.parseInt(br.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int x = 0;
        int i = 0;
        int j = arr.length - 1;
        String answer = "";
        while (i < j){
            int sum = arr[i] + arr[j];
            if (sum == x) {
                answer = arr[i] + " " + arr[j];
                break;
            } else if (sum > x) {
                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer = arr[i] + " " + arr[j];
                }
                j--;
            } else {
                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer = arr[i] + " " + arr[j];
                }
                i++;
            }
        }
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
