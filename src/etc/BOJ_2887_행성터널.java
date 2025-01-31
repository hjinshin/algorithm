package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2887_행성터널 {
    static int N;
    static int result;
    static int[] parents;
    static List<int[]> nodes = new ArrayList<>();
    static PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            nodes.add(new int[]{i, x, y, z});
        }

        getEdges();
        mst();
        System.out.println(result);
    }

    static void getEdges() {
        for (int i = 1; i <= 3; i++) {
            int stand = i;
            nodes.sort(Comparator.comparingInt(o -> o[stand]));
            for(int j = 0; j < N - 1; j++) {
                int diff = Math.abs(nodes.get(j)[stand] - nodes.get(j + 1)[stand]);
                edges.add(new Edge(nodes.get(j)[0], nodes.get(j + 1)[0], diff));
            }
        }
    }

    static void mst() {
        while(!edges.isEmpty()) {
            Edge e = edges.poll();
            if(find(e.u) != find(e.v)) {
                result += e.w;
                union(e.u, e.v);
            }
        }
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(parents[x] != parents[y]) {
            parents[x] = y;
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