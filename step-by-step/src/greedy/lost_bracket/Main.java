package greedy.lost_bracket;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1541 - 잃어버린 괄호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String formula = br.readLine();
        int index = formula.indexOf("-");
        String addition;
        String subtraction = "0";
        if (index > 0) {
            addition = formula.substring(0, index);
            subtraction = formula.substring(index+1);
        } else {
            addition = formula;
        }
        int sumAddition = Arrays.stream(addition.split("\\+")).mapToInt(Integer::parseInt).sum();
        int sumSubtraction = Arrays.stream(subtraction.split("[\\+\\-]")).mapToInt(Integer::parseInt).sum();

        int result = sumAddition - sumSubtraction;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
