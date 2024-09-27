package ch8_graph.bellman_ford;

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
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N];
        earn = new int[N];
        graph = new List[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
            graph[u].add(v);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earn[i] = Integer.parseInt(st.nextToken());
        }

        bellmanFord();

        if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        }else if (checkCycle()) {
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
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.u, v = edge.v, w = edge.w;
                if(dist[u] == Long.MIN_VALUE) continue;
                if (dist[u] == Long.MAX_VALUE) {
                    dist[v] = Long.MAX_VALUE;
                } else if (dist[v] < dist[u] + earn[v] - w) {
                    dist[v] = dist[u] + earn[v] - w;
                }
            }
        }
    }

    static boolean checkCycle() {
        for(Edge e : edges) {
            int u = e.u, v = e.v, w = e.w;
            if(dist[u] == Long.MIN_VALUE) continue;
            if (dist[u] == Long.MAX_VALUE) {
                dist[v] = Long.MAX_VALUE;
            } else if (dist[v] < dist[u] + earn[v] - w) {
                if (bfs(v, end)) return true;
            }
        }
        return false;
    }

    static boolean bfs(int st, int end) {
        if(st == end) return true;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(st);
        visited[st] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : graph[u]) {
                if(!visited[v]) {
                    if(v == end) return true;
                    visited[v] = true;
                    q.add(v);
                }
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
