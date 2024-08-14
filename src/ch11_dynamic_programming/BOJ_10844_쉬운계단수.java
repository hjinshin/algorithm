package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운계단수 {
    static final int MOD = 1_000_000_000;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP = new int[N + 1][10];
        for (int i = 1; i < 10; i++) {
            DP[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            DP[i][0] = DP[i - 1][1];
            DP[i][9] = DP[i - 1][8];

            for (int j = 1; j <= 8; j++) {
                DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % MOD;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + DP[N][i]) % MOD;
        }
        System.out.println(sum);
    }
}
