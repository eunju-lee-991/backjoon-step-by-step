package string.check_it_is_palindrom;

import java.io.InputStreamReader;
import java.util.Scanner;

// 10988 - 팰린드롬인지 확인하기
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String input = sc.next();
        sc.close();

        for (int i = 0; i < input.length() / 2; i++) {
             if(input.charAt(i) != input.charAt(input.length()-1-i)) {
                 System.out.print("0");
                 return;
             }
        }
        System.out.print("1");
    }
}
