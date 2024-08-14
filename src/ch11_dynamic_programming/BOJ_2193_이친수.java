package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_이친수 {
    static long[][] DP;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new long[N + 1][2];
        DP[1][1] = 1;
        DP[1][0] = 0;
        for (int i = 2; i <= N; i++) {
            DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
            DP[i][1] = DP[i - 1][0];
        }
        System.out.println(DP[N][0] + DP[N][1]);
    }
}
