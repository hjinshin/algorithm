package ch8.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1414_불우이웃돕기 {
    static int N;
    static int[] parent;
    static int total, edgeCount;
    static PriorityQueue<Edge> pq;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                int c = s.charAt(j);
                if(c == '0') continue;
                int w = 0;
                if(c >= 'a' && c <= 'z') {
                    w += c - 'a' + 1;
                }else if(c >= 'A' && c <= 'Z') {
                    w += c - 'A' + 27;
                }
                total += w;
                if(i == j)  continue;
                pq.add(new Edge(i, j, w));
            }
        }
        mst();
        if (edgeCount < N - 1) {
            System.out.println("-1");
        } else {
            System.out.println(total);
        }
    }

    static void mst() {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if(find(e.u) != find(e.v)) {
                union(e.u, e.v);
                total -= e.w;
                edgeCount++;
            }
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
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
