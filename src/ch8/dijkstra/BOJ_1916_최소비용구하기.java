package ch8.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<Edge>[] graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[dest]);
    }
    public static void dijkstra(int start) {
        for(int i=1; i <= N; i++) {
            dist[i] = INF;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge node = pq.poll();
            int u = node.v;
            if(visited[u]) continue;
            visited[u] = true;
            for (Edge edge : graph[u]) {
                if(dist[edge.v] > edge.w + dist[u]) {
                    dist[edge.v] = edge.w + dist[u];
                    pq.add(new Edge(edge.v, dist[edge.v]));
                }
            }
        }
    }
    static class Edge {
        int v, w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

}