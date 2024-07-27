package ch10_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2_DP {
    static final int MOD = 10_007;
    static int N, K;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        DP = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            DP[i][0] = 1;
            DP[i][1] = i;
            DP[i][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
                DP[i][j] %= MOD;
            }
        }
        System.out.println(DP[N][K]);

    }
}
