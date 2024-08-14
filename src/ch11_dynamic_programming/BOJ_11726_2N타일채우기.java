package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2N타일채우기 {
    static final int MOD = 10_007;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
        DP[1] = 1;
        if (N > 1) {
            DP[2] = 2;
        }

        for (int i = 3; i <= N; i++) {
            DP[i] = DP[i - 1] % MOD + DP[i - 2] % MOD;
        }
        System.out.println(DP[N] % MOD);
    }
}
