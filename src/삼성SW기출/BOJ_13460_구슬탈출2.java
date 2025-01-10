package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static char[][] map;
    static Pos redBall, blueBall, hole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for(int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    redBall = new Pos(i, j);
                } else if (map[i][j] == 'B') {
                    blueBall = new Pos(i, j);
                } else if (map[i][j] == 'O') {
                    hole = new Pos(i, j);
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][][][] visited = new boolean[N][M][N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{redBall.y, redBall.x, blueBall.y, blueBall.x, 0});
        visited[redBall.y][redBall.x][blueBall.y][blueBall.x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[4] >= 10)    continue;

            for(int i = 0; i < 4; i++) {
                Pos curRed = new Pos(cur[0], cur[1]);
                Pos curBlue = new Pos(cur[2], cur[3]);
                boolean redFlag = false; boolean blueFlag = false;

                while (true) {
                    Pos newRed = new Pos(curRed.y, curRed.x);
                    Pos newBlue = new Pos(curBlue.y, curBlue.x);
                    Pos nextRed = new Pos(curRed.y + dy[i], curRed.x + dx[i]);
                    Pos nextBlue = new Pos(curBlue.y + dy[i], curBlue.x + dx[i]);

                    // 다음 위치가 벽이 아니거나, 파란 공이 없을 경우 이동
                    if (!isWall(nextRed) && !comparePos(nextRed, newBlue)) {
                        newRed.move(dy[i], dx[i]);
                    }
                    // 다음 위치가 벽이 아니거나, 빨간공이 없는 경우 이동. 이때 빨간공이 구멍에 빠졌다면 비어있다고 판단
                    if (!isWall(nextBlue) && (!comparePos(nextBlue, newRed) || redFlag)) {
                        newBlue.move(dy[i], dx[i]);
                    }

                    if (isHole(newRed)) {
                        redFlag = true;
                    }
                    if (isHole(newBlue)) {
                        blueFlag = true;
                        break;
                    }

                    // 두 공 모두 위치가 변하지 않았다면 탈출
                    if(comparePos(newRed, curRed) && comparePos(newBlue, curBlue)) break;

                    // 변경 사항 업데이트
                    curRed = newRed;
                    curBlue = newBlue;
                }

                if (blueFlag) continue;
                if(redFlag) return cur[4] + 1;

                if(!visited[curRed.y][curRed.x][curBlue.y][curBlue.x]) {
                    queue.add(new int[] {curRed.y, curRed.x, curBlue.y, curBlue.x, cur[4] + 1});
                    visited[curRed.y][curRed.x][curBlue.y][curBlue.x] = true;
                }
            }
        }

        return -1;
    }

    static boolean isWall(Pos pos) {
        return map[pos.y][pos.x] == '#';
    }

    static boolean isHole(Pos pos) {
        return comparePos(pos, hole);
    }

    static boolean comparePos(Pos p1, Pos p2) {
        return ((p1.y == p2.y) && (p1.x == p2.x));
    }

    static class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        void move(int dy, int dx) {
            this.y += dy;
            this.x += dx;
        }
    }
}
