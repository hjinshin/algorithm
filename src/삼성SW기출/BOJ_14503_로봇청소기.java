package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulate(y, x, d);
    }

    static void simulate(int y, int x, int d) {
        int result = 0;
        while (true) {
            boolean flag = true;
            if (map[y][x] == 0) {
                map[y][x] = -1;
                result += 1;
            }
            for (int i = 1; i <= 4; i++) {
                int nd = (d - i + 4) % 4;
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if (ny < 0 && ny >= N && nx < 0 && nx >= M) continue;
                if (map[ny][nx] == 0) {
                    flag = false;
                    y = ny;
                    x = nx;
                    d = nd;
                    break;
                }
            }
            if (flag) {
                int nd = (d + 2) % 4;
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if(map[ny][nx] == 1) break;
                y = ny;
                x = nx;
            }
        }
        System.out.println(result);
    }
}