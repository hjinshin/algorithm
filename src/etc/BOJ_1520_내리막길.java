package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int i, int j) {
        if(i == N - 1 && j == M - 1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];
            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (arr[i][j] > arr[ny][nx]) {
                dp[i][j] += dfs(ny, nx);
            }
        }
        return dp[i][j];
    }
}