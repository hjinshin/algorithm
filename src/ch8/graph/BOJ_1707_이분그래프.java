package ch8.graph;

import java.io.*;
import java.util.*;

public class BOJ_1707_이분그래프 {
    static List<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        for(int k=0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V+1];
            visited = new int[V+1];
            for(int i=0; i<V+1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            System.out.println(bfs());
        }
    }

    public static String bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<graph.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
            }

            while(!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : graph[u]) {
                    if(visited[v] == visited[u]) {
                        return "NO";
                    }
                    if(visited[v] == 0) {
                        queue.add(v);
                        if(visited[u] == 1) {
                            visited[v] = 2;
                        } else {
                            visited[v] = 1;
                        }
                    }

                }
            }
        }
        return "YES";
    }
}
