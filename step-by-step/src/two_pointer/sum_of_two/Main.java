package two_pointer.sum_of_two;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3273 두 수의 합
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
        int count = 0;
        int x = Integer.parseInt(br.readLine());
        int i =0;
        int j = arr.length - 1;
        while (i < j ){
            int sum = arr[i] + arr[j];
            if(sum == x){
                count++;
                i++;
            } else if (sum < x){
                i++;
            } else {
                j--;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
