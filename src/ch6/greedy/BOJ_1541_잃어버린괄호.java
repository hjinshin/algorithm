package ch6.greedy;

import java.io.*;

public class BOJ_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split("-");
        int result = 0;
        result = sum(str[0]);
        for (int i = 1; i < str.length; i++) {
            result -= sum(str[i]);
        }
        System.out.println(result);
    }

    public static int sum(String s) {
        int sum = 0;
        String[] nums = s.split("\\+");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
