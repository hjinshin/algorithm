package ch8_graph.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<Edge>[] graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new List[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }
        dijkstra(K);
        for(int i = 1; i <= V; i++) {
            if(dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static void dijkstra(int start) {
        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> {
            int w1 = o1.w;
            int w2 = o2.w;
            return w1 - w2;
        }));
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge node = pq.poll();
            int u = node.v;
            if(visited[u]) continue;
            visited[u] = true;
            for (Edge edge : graph[u]) {
                if (dist[edge.v] > edge.w + dist[u]) {
                    dist[edge.v] = edge.w + dist[u];
                    pq.add(new Edge(edge.v, dist[edge.v]));
                }
            }
        }
    }
    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

}