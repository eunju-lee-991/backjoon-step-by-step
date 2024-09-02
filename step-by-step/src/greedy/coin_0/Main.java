package greedy.coin_0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 11047 - 동전 0
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int money;
        int count = 0;

        while (i < N){
            money = Integer.parseInt(br.readLine());
            if(money > K ) break;
            list.add(money);
            i++;
        }
        br.close();

        for (int j = list.size() - 1; j >= 0; j--) {
            count += K / list.get(j);
            K %= list.get(j);
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
