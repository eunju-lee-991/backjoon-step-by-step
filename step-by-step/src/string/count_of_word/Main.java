package string.count_of_word;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 1152 - 단어의 개수
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine().strip();
        br.close();
        bw.write( input.equals("") ? "0" : input.split(" ").length + "");
        bw.close();
    }
}