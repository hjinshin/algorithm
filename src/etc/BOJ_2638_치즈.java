package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int N, M;
    static Block[][] blocks;
    static Queue<int[]> melted = new LinkedList<>();
    static boolean[][] visited;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        blocks = new Block[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                blocks[i][j] = new Block(i, j, k);
            }
        }
        dfs(0, 0);
        while (!melted.isEmpty()) {
            melting();
            time++;
        }
        System.out.println(time);
    }

    static void melting() {
        int queueSize = melted.size();
        for(int i = 0; i < queueSize; i++) {
            int[] pos = melted.poll();
            blocks[pos[0]][pos[1]].cheese = 0;
            dfs(pos[0], pos[1]);
        }
    }

    static void dfs(int y, int x) {
        Queue<Block> q = new LinkedList<>();
        q.add(blocks[y][x]);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Block block = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = block.y + dy[i];
                int nx = block.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (!visited[ny][nx] && !blocks[ny][nx].isCheese()) {
                    visited[ny][nx] = true;
                    q.add(blocks[ny][nx]);
                }
                if (blocks[ny][nx].isCheese()) {
                    blocks[ny][nx].contact++;
                    if (blocks[ny][nx].contact == 2) {
                        melted.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    static class Block {
        int cheese, contact;
        int y, x;
        public Block(int y, int x, int cheese) {
            this.y = y;
            this.x = x;
            this.cheese = cheese;
        }

        public boolean isCheese() {
            return cheese == 1;
        }
    }
}
