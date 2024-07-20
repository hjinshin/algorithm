package ch5_search.dfs;

import java.io.*;
import java.util.*;

public class BOJ_11724_연결요소의개수 {
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        int result = 0;
        for (int i = 1; i < list.length; i++) {
            if (!visited[i]) {
                result++;
            }
            dfs(i);
        }
        System.out.println(result);
    }

    public static void dfs(int u) {
        if(visited[u]) return;
        visited[u] = true;
        for (int i : list[u]) {
            dfs(i);
        }
    }
}
