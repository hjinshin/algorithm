package ch9_tree.lca;

import java.io.*;
import java.util.*;

public class BOJ_11438_LCA2 {
    static int N, M;
    static int height;
    static int[] depth;
    static int[][] parent;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        height = (int) (Math.log(N) / Math.log(2));
        depth = new int[N + 1];
        parent = new int[height + 1][N + 1];
        tree = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        bfs(1);
        for(int i=1; i<=height; i++){
            for(int j=1; j<=N; j++){
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(lca(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        depth[start] = 0;
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer i : tree[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    depth[i] = depth[now] + 1;
                    parent[0][i] = now;
                    queue.add(i);
                }
            }
        }
    }

    static int lca(int a, int b) {
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = height; i >= 0; i--) {
            if (depth[b] - depth[a] >= Math.pow(2, i)) {
                b = parent[i][b];
            }
        }
        for(int i=height; i >= 0; i--) {
            if(parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        int result = a;
        if (a != b) {
            result = parent[0][a];
        }
        return result;
    }
}
