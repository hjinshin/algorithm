package ch5.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
    static int[][] tree;
    static boolean[] visited;
    static int diameter;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[u][v] = w;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                bfs(i, j);
                visited = new boolean[]{false};
            }
        }


    }

    public static void bfs(int u, int v) {

    }
}
