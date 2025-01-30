package implementation.resort_string;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 이코테 문자열 재정렬
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        List<Character> chars = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char charValue = input.charAt(i);
            if (charValue >= '0' && charValue <= '9') {
                ints.add(charValue - '0');
            } else {
                chars.add(charValue);
            }
        }
        Collections.sort(chars);
        for (char c : chars) {
            bw.write(Character.toString(c));
        }
        if(!ints.isEmpty()){
            int sum = 0;
            for(int i : ints){
                sum += i;
            }
            bw.write(sum+"");
        }
        bw.close();
    }
}
