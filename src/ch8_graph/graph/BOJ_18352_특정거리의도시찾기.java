package ch8_graph.graph;

import java.util.*;
import java.io.*;

public class BOJ_18352_특정거리의도시찾기 {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        bfs(X);
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        }

    }

    static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph[u]) {
                if (!visited[v] && distance[u] < K) {
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    if (distance[v] == K) {
                        result.add(v);
                        continue;
                    }
                    queue.add(v);
                }
            }
        }
    }
}
