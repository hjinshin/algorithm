package ch9_tree.lca;

import java.io.*;
import java.util.*;

public class BOJ_11437_LCA {
    static int N, M;
    static List<Integer>[] tree;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new List[N + 1];
        parent = new int[N + 1];
        depth = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        bfs(1);

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
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        queue.add(start);
        depth[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer i : tree[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    parent[i] = cur;
                    queue.add(i);
                    depth[i] = depth[cur] + 1;
                }
            }
        }
    }

    static int lca(int a, int b) {
        while (a != b) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }
        return a;
    }
}
