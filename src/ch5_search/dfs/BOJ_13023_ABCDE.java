package ch5_search.dfs;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        int u,v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 0; i < list.length; i++) {
            dfs(i, 1);
            if (result == 1) {
                break;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int u, int depth) {
        if(visited[u])  return;
        if (depth == 5 || result == 1) {
            result = 1;
            return;
        }
        visited[u] = true;
        for (int i : list[u]) {
            dfs(i, depth+1);
        }
        visited[u] = false;
    }
}
