package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234_인구이동 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());

    }

    static int move() {
        int day = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            int[][] tempA = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    tempA[i][j] = A[i][j];
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if(bfs(tempA, i, j)) flag = true;
                    }
                }
            }
            if(!flag) break;
            day++;
        }

        return day;
    }

    static boolean bfs(int[][] tempA, int y, int x) {
        List<Pos> list = new ArrayList<>();
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(y, x));
        list.add(new Pos(y, x));
        visited[y][x] = true;
        int count = 1;
        int sum = tempA[y][x];
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                int diff = Math.abs(tempA[ny][nx] - tempA[cur.y][cur.x]);
                if(!visited[ny][nx] && diff >= L && diff <= R) {
                    sum += tempA[ny][nx];
                    count++;
                    visited[ny][nx] = true;
                    queue.add(new Pos(ny, nx));
                    list.add(new Pos(ny, nx));
                }
            }
        }
        int res = sum / count;
        if(count == 1) return false;
        for (Pos pos : list) {
            A[pos.y][pos.x] = res;
        }
        return true;
    }

    static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
