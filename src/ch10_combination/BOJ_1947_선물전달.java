package ch10_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1947_선물전달 {
    static final int MOD = 1_000_000_000;
    static int N;
    static long[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        D = new long[N + 1];
        D[1] = 0;
        if(N >= 2)
            D[2] = 1;

        for (int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % MOD;
        }
        System.out.println(D[N]);
    }
}
