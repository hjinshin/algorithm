package ch8_graph.bellman_ford;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static long[] dist;
    static List<Edge> edges = new ArrayList<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        bellmanFord();
        if (isNegativeCycle()) {
            bw.write("-1\n");
        } else {
            for(int i=2; i<=N; i++) {
                if(dist[i] == INF) {
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i] + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    static void bellmanFord() {
        for (int i = 2; i <= N; i++) {
            dist[i] = INF;
        }
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.u, v = edge.v, w = edge.w;
                if (dist[u] != INF && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }
    }

    static boolean isNegativeCycle() {
        for (Edge edge : edges) {
            int u = edge.u, v = edge.v, w = edge.w;
            if (dist[u] != INF && dist[v] > dist[u] + w) {
                return true;
            }
        }
        return false;
    }
    static class Edge {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}

