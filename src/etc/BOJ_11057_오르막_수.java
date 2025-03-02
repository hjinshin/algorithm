package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057_오르막_수 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[10][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 0 || j == 0) {
                    dp[j][i] = 1;
                    continue;
                }
                dp[j][i] = (dp[j - 1][i] + dp[j][i - 1]) % 10_007;
            }
        }

        System.out.println(dp[9][N]);
    }

}