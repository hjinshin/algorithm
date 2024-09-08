package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
    static int T, N;
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N + 1];
            int[][] DP = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DP[0][1] = stickers[0][1];
            DP[1][1] = stickers[1][1];
            for (int j = 2; j <= N; j++) {
                DP[0][j] = Math.max(DP[1][j - 1], DP[1][j - 2]) + stickers[0][j];
                DP[1][j] = Math.max(DP[0][j - 1], DP[0][j - 2]) + stickers[1][j];
            }
            System.out.println(Math.max(DP[0][N], DP[1][N]));
        }
    }
}