package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240_자두나무 {
    static int T, W;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T + 1];
        dp = new int[T + 1][2][W + 1];

        for(int i = 1; i < T + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int t = 1; t <= T; t++) {
            for (int k = 0; k < 2; k++) {
                int start = 0;
                if(t == 1 && k == 1)    start = 1;
                for (int w = start; w <= W; w++) {
                    dp[t][k][w] = dp[t - 1][k][w];
                    if (w != 0) {
                        dp[t][k][w] = Math.max(dp[t][k][w], dp[t - 1][1 - k][w - 1]);
                    }
                    if (k == arr[t]) {
                        dp[t][k][w]++;
                    }

                }
            }
        }

        int max = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= W; j++) {
                max = Math.max(max, dp[T][i][j]);
            }
        }
        System.out.println(max);
    }
}