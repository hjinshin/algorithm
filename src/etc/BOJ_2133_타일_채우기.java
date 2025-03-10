package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133_타일_채우기 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        if (N >= 2) {
            dp[2] = 3;
        }
        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2;
            int j = i - 4;
            while (j > 0) {
                dp[i] += dp[j] * 2;
                j -= 2;
            }
        }

        System.out.println(dp[N]);
    }
}