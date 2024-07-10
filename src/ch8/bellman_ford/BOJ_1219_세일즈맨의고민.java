package ch8.bellman_ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1219_세일즈맨의고민 {
    static int N, M;
    static int start, end;
    static long[] dist;
    static int[] earn;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N];
        earn = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earn[i] = Integer.parseInt(st.nextToken());
        }

        bellmanFord();

        if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if(dist[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(dist[end]);
        }
    }

    static void bellmanFord() {
        for(int i=0; i < N; i++) {
            dist[i] = Long.MIN_VALUE;
        }
        dist[start] = earn[start];
        for (int i = 0; i < N * 2; i++) {
            for (Edge edge : edges) {
                int u = edge.u, v = edge.v, w = edge.w;
                if(dist[u] == Long.MIN_VALUE) continue;
                if (dist[u] == Long.MAX_VALUE) {
                    dist[v] = Long.MAX_VALUE;
                } else if (dist[v] < dist[u] + earn[v] - w) {
                    dist[v] = dist[u] + earn[v] - w;
                    if (i > N - 1)  dist[v] = Long.MAX_VALUE;
                }
            }
        }
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
