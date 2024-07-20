package ch8_graph.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
    static int N, M;
    static PriorityQueue<Edge> pq;
    static int[] parent;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        pq = new PriorityQueue<>((o1, o2) -> {
            int w1 = o1.w;
            int w2 = o2.w;
            return w1 - w2;
        });
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }
        mst();
        System.out.println(result);
    }

    public static void mst() {
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if(find(e.u) != find(e.v)) {
                union(e.u, e.v);
                result += e.w;
            }
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY)
            parent[rootX] = rootY;
    }

    static class Edge {
        int u,v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
