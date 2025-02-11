package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(!visited[ny][nx]) {
                if (cnt == 2) {
                    visited[ny][nx] = true;
                    dfs(x, y, cnt + 1, sum + map[ny][nx]);
                    visited[ny][nx] = false;
                }
                visited[ny][nx] = true;
                dfs(nx, ny, cnt + 1, sum + map[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }
}