package ch8_graph.topological_sorting;

import java.io.*;
import java.util.*;

public class BOJ_1948_임계경로 {
    static int n, m;
    static List<Edge>[] graph;
    static List<Edge>[] revGraph;
    static int[] edges;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        revGraph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        edges = new int[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            revGraph[v].add(new Edge(u, w));
            edges[v]++;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        topologicalSort(start);
        bw.write(dist[end] + "\n");
        bw.write(pathCount(end) + "\n");
        bw.flush();
        bw.close();
    }
    public static void topologicalSort(int start) {
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(start, 0));
        while (!q.isEmpty()) {
            Edge node = q.poll();
            int u = node.v;
            for (Edge e : graph[u]) {
                edges[e.v]--;
                if(dist[e.v] < dist[u] + e.w) {
                    dist[e.v] = dist[u] + e.w;
                }
                if(edges[e.v] == 0) {
                    q.add(new Edge(e.v, e.w));
                }
            }
        }
    }

    public static int pathCount(int end) {
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(end);
        visited[end] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            for(Edge e : revGraph[u]) {
                if(dist[u] == dist[e.v] + e.w) {
                    count++;
                    if(!visited[e.v]) {
                        q.add(e.v);
                        visited[e.v] = true;
                    }
                }
            }
        }
        return count;
    }

    static class Edge {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
