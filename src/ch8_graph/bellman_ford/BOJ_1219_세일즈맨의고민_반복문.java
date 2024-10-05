package ch8_graph.bellman_ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1219_세일즈맨의고민_반복문 {
    static int N, M;
    static int source, dest;
    static long[] result;
    static int[] money;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        source = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new long[N];
        money = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        bellmanFord();
        checkCycle();

        if (result[dest] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (result[dest] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(result[dest]);
        }

    }

    static void bellmanFord() {
        for(int i = 0; i < N; i++) {
            result[i] = Long.MIN_VALUE;
        }
        result[source] = money[source];

        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.u, v = edge.v, w = edge.w;
                if(result[u] == Long.MIN_VALUE) continue;
                if (result[u] == Long.MAX_VALUE) {
                    result[v] = Long.MAX_VALUE;
                } else if (result[v] < result[u] + money[v] - w) {
                    result[v] = result[u] + money[v] - w;
                }
            }
        }
    }

    static void checkCycle() {
        int cnt = N * (N - 1) / 2 + 1;

        for (int i = 0; i < cnt; i++) {
            for (Edge edge : edges) {
                int u = edge.u, v = edge.v, w = edge.w;
                if(result[u] == Long.MIN_VALUE) continue;
                if(result[u] == Long.MAX_VALUE) {
                    result[v] = Long.MAX_VALUE;
                } else if(result[v] < result[u] + money[v] - w) {
                    result[v] = Long.MAX_VALUE;
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
