package ch3.section_sum;

import java.util.Scanner;

public class BOJ_10986_나머지합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] S = new long[n];
        long[] C = new long[m];
        long answer = 0;

        S[0] = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            S[i] = S[i-1] + scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int remainder = (int) (S[i] % m);
            if (remainder == 0) {
                answer++;
            }
            C[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (C[i] >1 ) {
                answer += C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}
