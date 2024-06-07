package ch5.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String l = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(l.substring(j, j+1));
            }
        }

        bfs(0, 0);
        System.out.println(dist[N-1][M-1]);
    }

    static void bfs(int s_y, int s_x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s_y, s_x});
        visited[s_y][s_x] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int n_y = pos[0];
            int n_x = pos[1];

            dist[n_y][n_x]++;

            for (int i = 0; i < 4; i++) {
                int d_y = n_y + dy[i];
                int d_x = n_x + dx[i];

                if (d_y < 0 || d_x < 0 || d_y >= N || d_x >= M) {
                    continue;
                }
                if (map[d_y][d_x] == 0 || visited[d_y][d_x]) {
                    continue;
                }

                queue.add(new int[]{d_y, d_x});
                visited[d_y][d_x] = true;
                dist[d_y][d_x] = dist[n_y][n_x];
            }
        }
    }
}
