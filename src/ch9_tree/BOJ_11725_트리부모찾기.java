package ch9_tree;

import java.io.*;
import java.util.*;

public class BOJ_11725_트리부모찾기 {
    static int N;
    static List<Integer>[] tree;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new List[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
//        bfs(1);
        dfs(1);
        for (int i = 2; i <= N; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Integer v : tree[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    result[v] = u;
                    queue.add(v);
                }
            }
        }
    }

    static void dfs(int u) {
        visited[u] = true;
        for (Integer v : tree[u]) {
            if(!visited[v]) {
                result[v] = u;
                dfs(v);
            }
        }
    }
}
