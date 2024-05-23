package ch3.stack;

import java.io.*;
import java.util.*;

public class BOJ_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int target = A[i];
            if (target >= num) {
                while (target >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int p = stack.pop();

                if(p > target) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if (result) {
            System.out.println(bf);
        }
    }
}
