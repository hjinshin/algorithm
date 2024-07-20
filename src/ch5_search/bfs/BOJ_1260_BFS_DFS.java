package ch5_search.bfs;

import java.io.*;
import java.util.*;

public class BOJ_1260_BFS_DFS {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(tree[i]);
        }

        dfs(V);
        bw.write("\n");
        visited = new boolean[N + 1];
        bfs(V);
        bw.flush();
        bw.close();
    }

    public static void dfs(int u) throws IOException {
        if (visited[u]) {
            return;
        }
        bw.write(u + " ");
        visited[u] = true;
        for (int i : tree[u]) {
            dfs(i);
        }
    }

    public static void bfs(int u) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;

        while (!queue.isEmpty()) {
            int q_u = queue.poll();
            bw.write(q_u + " ");
            for (int q_v : tree[q_u]) {
                if(visited[q_v]) continue;
                queue.add(q_v);
                visited[q_v] = true;
            }
        }
    }
}
