package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    static int N;
    static int[] DP;
    static int[] T;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        DP = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i >= 1; i--) {
            DP[i] = DP[i + 1];
            if (i + T[i] > N + 1) {
                DP[i] = DP[i + 1];
            } else {
                DP[i] = Math.max(DP[i + 1], DP[i + T[i]] + P[i]);
            }
        }
        System.out.println(DP[1]);
    }
}