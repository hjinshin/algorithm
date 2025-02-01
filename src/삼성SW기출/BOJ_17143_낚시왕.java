package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int R, C, M;
    static Shark[][] map;
    static List<Shark> sharks = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d - 1, z);
            map[r][c] = shark;
            sharks.add(shark);
        }

        for (int i = 1; i <= C; i++) {
            catchShark(i);
            moveShark();
        }
        System.out.println(result);
    }

    static void catchShark(int x) {
        for(int i = 1; i <= R; i++) {
            if (map[i][x] != null) {
                result += map[i][x].size;
                map[i][x].isDead = true;
                break;
            }
        }
    }

    static void moveShark() {
        map = new Shark[R + 1][C + 1];
        for (Shark shark : sharks) {
            if(!shark.isDead) {
                shark.move();

                if(map[shark.y][shark.x] == null) {
                    map[shark.y][shark.x] = shark;
                } else if(shark.size > map[shark.y][shark.x].size) {
                    map[shark.y][shark.x].isDead = true;
                    map[shark.y][shark.x] = shark;
                } else {
                    shark.isDead = true;
                }
            }
        }
    }

    static class Shark {
        int y, x;
        int speed;
        int d;
        int size;
        boolean isDead;

        Shark(int r, int c, int s, int d, int z) {
            this.y = r;
            this.x = c;
            this.speed = s;
            this.d = d;
            this.size = z;
        }

        void move() {
            y = y + dy[d] * speed;
            x = x + dx[d] * speed;
            while (y <= 0 || y > R) {
                if (y > R) {
                    y = R - (y - R);
                    d = 0;
                }
                if(y <= 0) {
                    y = 1 + (1 - y);
                    d = 1;
                }
            }
            while (x <= 0 || x > C) {
                if (x > C) {
                    x = C - (x - C);
                    d = 3;
                }
                if(x <= 0) {
                    x = 1 + (1 - x);
                    d = 2;
                }
            }
        }
    }
}
