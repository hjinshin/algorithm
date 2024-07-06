package ch8.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ_1854_K번째최단경로 {
    static final int INF = Integer.MAX_VALUE;
    static int n, m, k;
    static PriorityQueue<Integer>[] dist;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        dist = new PriorityQueue[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        for(int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }
        dijkstra(1);
        for(int i=1; i<=n; i++) {
            if(dist[i].size() < k) bw.write("-1\n");
            else bw.write(dist[i].poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        dist[start].add(0);
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge node = pq.poll();
            int u = node.v;
            for(int next=1; next<=n; next++) {
                if (graph[u][next] != 0) {
                    int distance = node.w + graph[u][next];
                    if (ckeckDistPQ(next, distance)) {
                        pq.add(new Edge(next, distance));
                    }
                }
            }
        }
    }

    public static boolean ckeckDistPQ(int next, int distance) {
        if (dist[next].size() >= k) {
            if(distance > dist[next].peek()) return false;
        }
        dist[next].add(distance);
        while(dist[next].size() > k) {
            dist[next].poll();
        }
        return true;
    }

    static class Edge {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
