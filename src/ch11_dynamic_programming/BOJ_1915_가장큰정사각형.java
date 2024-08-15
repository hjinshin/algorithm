package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915_가장큰정사각형 {
    static int[][] DP;
    static int N, M, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        DP = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] arr = st.nextToken().toCharArray();
            for (int j = 1; j <= M; j++) {
                DP[i][j] = arr[j - 1] - '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (DP[i][j] == 1) {
                    DP[i][j] = Math.min(DP[i - 1][j - 1], Math.min(DP[i][j - 1], DP[i - 1][j])) + 1;
                }
                if(DP[i][j] > max) max = DP[i][j];
            }
        }

        System.out.println(((long) max * max));
    }
}
