package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int N, M;
    static char[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        bfs();
        if(result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    static void bfs() {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 1, 0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            if(pos.x == M - 1 && pos.y == N - 1) {
                result = pos.count;
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (map[ny][nx] == '1' && !visited[ny][nx][1]) {
                    if(pos.wall == 1)    continue;
                    visited[ny][nx][1] = true;
                    queue.add(new Pos(ny, nx, pos.count + 1, 1));
                } else if(map[ny][nx] == '0' && !visited[ny][nx][pos.wall]) {
                    visited[ny][nx][pos.wall] = true;
                    queue.add(new Pos(ny, nx, pos.count + 1, pos.wall));
                }
            }
        }
    }

    static class Pos {
        int y, x, count;
        int wall;
        Pos(int y, int x, int count, int wall) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.wall = wall;
        }
    }
}
