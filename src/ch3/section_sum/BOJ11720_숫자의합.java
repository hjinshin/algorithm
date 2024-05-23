package ch3.section_sum;

import java.util.Scanner;


public class BOJ11720_숫자의합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;
        String sNums = scanner.next();
        char[] cNums = sNums.toCharArray();

        for (char cNum : cNums) {
            result += cNum - '0';
        }
        System.out.println(result);
    }
}
