package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int start_y = Integer.parseInt(st.nextToken());
        int start_x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(start_x, start_y);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int op = Integer.parseInt(st.nextToken()) - 1;
            if(!checkMap(op, dice.x, dice.y)) continue;
            dice.roll(op);
            if(map[dice.y][dice.x] == 0) {
                map[dice.y][dice.x] = dice.printBottom();
            } else {
                dice.copyBottom(map[dice.y][dice.x]);
                map[dice.y][dice.x] = 0;
            }
            dice.printTop();
        }
    }

    static boolean checkMap(int op, int x, int y) {
        int ny = y + dy[op]; int nx = x + dx[op];
        if(ny < 0 || ny >= N || nx < 0 || nx >= M) return false;
        return true;
    }

    static class Dice {
        int[] die = {0, 0, 0, 0, 0, 0, 0};
        int top = 1, right = 3, up = 2;
        int x, y;

        public Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void roll(int op) {
            y += dy[op]; x += dx[op];
            int bottom = 7 - top;
            int left = 7 - right;
            int down = 7 - up;
            if (op == 0) {
                right = top;
                top = left;
            } else if (op == 1) {
                top = right;
                right = bottom;
            } else if (op == 2) {
                up = top;
                top = down;
            } else {
                top = up;
                up = bottom;
            }
        }

        public void printTop() {
            System.out.println(die[top]);
        }

        public void copyBottom(int num) {
            die[7 - top] = num;
        }

        public int printBottom() {
            return die[7 - top];
        }
    }
}