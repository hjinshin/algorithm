package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {
    static int[] board = new int[101];
    static int[] DP = new int[101];
    static final int DICE = 6;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        for (int i = 2; i <= 100; i++) {
            DP[i] = 100;
        }
        dfs(1);

        System.out.println(DP[100]);
    }

    static void dfs(int pos) {
        if(pos == 100) return;
        if (board[pos] != 0) {
            DP[board[pos]] = DP[pos];
            dfs(board[pos]);
        } else {
            for (int i = 1; i <= DICE; i++) {
                if(pos + i > 100)   break;
                if (DP[pos + i] > DP[pos] + 1) {
                    DP[pos + i] = DP[pos] + 1;
                    dfs(pos + i);
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int pos = q.poll();
            if (board[pos] != 0) {
                DP[board[pos]] = DP[pos];
                q.add(board[pos]);
            } else {
                for (int i = 1; i <= DICE; i++) {
                    if(pos + i > 100) continue;
                    if (DP[pos + i] > DP[pos] + 1) {
                        DP[pos + i] = DP[pos] + 1;
                        q.add(pos + i);
                    }
                }
            }
        }
    }
}
