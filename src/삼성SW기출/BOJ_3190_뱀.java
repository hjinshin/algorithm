package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int N, K, L;
    static int count;
    static int[][] board;
    static Queue<Op> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            queue.add(new Op(x, c));
        }
        System.out.println(game());
    }

    static int game() {
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});
        int size = 1;
        int sec = 0;
        int pos_X = 1, pos_Y = 1;
        int direction = 0;
        Op op = queue.poll();

        while (true) {
            sec++;
            pos_Y += dy[direction];
            pos_X += dx[direction];

            if(pos_X <= 0 || pos_Y <= 0 || pos_X > N || pos_Y > N) break;
            if(board[pos_Y][pos_X] == -1) break;
            if(board[pos_Y][pos_X] == 1) size++;
            board[pos_Y][pos_X] = -1;
            snake.add(new int[]{pos_Y, pos_X});
            if (snake.size() > size) {
                int[] pos = snake.poll();
                board[pos[0]][pos[1]] = 0;
            }

            if (op != null && op.time == sec) {
                if (op.direction == 'D') {
                    direction = (direction + 1) % 4;
                } else {
                    if(direction == 0) direction = 3;
                    else direction -= 1;
                }
                op = queue.poll();
            }
        }

        return sec;
    }

    static class Op {
        int time;
        char direction;

        public Op(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }
}
