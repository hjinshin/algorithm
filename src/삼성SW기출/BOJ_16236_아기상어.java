package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int N;
    static int[][] map;
    static int sX, sY;
    static int size = 2;
    static int stomach, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sY = i;
                    sX = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            int dist = bfs(sY, sX);
            if (dist == 0) {
                break;
            }
            result += dist;
        }

        System.out.println(result);
    }

    static int bfs(int y, int x) {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist != o2.dist) return o1.dist - o2.dist;
            if(o1.y != o2.y) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        visited[y][x] = true;
        q.add(new Pos(y, x, 0));

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (map[cur.y][cur.x] < size && map[cur.y][cur.x] > 0) {
                move(cur.y, cur.x);
                eat(cur.y, cur.x);
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nY = cur.y + dy[i];
                int nX = cur.x + dx[i];

                if (nY < 0 || nY >= N || nX < 0 || nX >= N) continue;
                if (visited[nY][nX]) continue;
                if (map[nY][nX] > size) continue;
                visited[nY][nX] = true;
                q.add(new Pos(nY, nX, cur.dist + 1));
            }
        }
        return 0;
    }

    static void move(int y, int x) {
        sY = y;
        sX = x;
    }

    static void eat(int y, int x) {
        map[y][x] = 0;
        stomach++;
        if (stomach == size) {
            size++;
            stomach = 0;
        }
    }

    static class Pos {
        int y, x, dist;

        public Pos(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
