package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int maxSafetyRoom;
    static Queue<Virus> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(maxSafetyRoom);
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Virus(i, j));
                }
                copyMap[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (copyMap[ny][nx] == 0) {
                        copyMap[ny][nx] = 2;
                        queue.add(new Virus(nx, ny));
                    }
                }
            }
        }

        countSafetyRoom(copyMap);
    }

    static void countSafetyRoom(int[][] copyMap) {
        int safetyRoom = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safetyRoom++;
                }
            }
        }
        maxSafetyRoom = Math.max(maxSafetyRoom, safetyRoom);
    }

    static class Virus {
        int x, y;

        Virus(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
