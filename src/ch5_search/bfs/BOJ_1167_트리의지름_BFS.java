package ch5_search.bfs;

import java.io.*;
import java.util.*;

public class BOJ_1167_트리의지름_BFS {
    static int N;
    static List<Edge>[] tree;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new List[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                Edge edge = new Edge(e, w);
                tree[u].add(edge);
            }
        }

        bfs(1);
        int maxNode = 1;
        for (int i = 1; i <= N; i++) {
            if (distance[maxNode] < distance[i]) {
                maxNode = i;
            }
        }
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        bfs(maxNode);
        int max = maxDistance();
        System.out.println(max);
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : tree[u]) {
                int e = edge.e;
                int w = edge.w;
                if (!visited[e]) {
                    queue.add(e);
                    distance[e] = distance[u] + w;
                    visited[e] = true;
                }
            }
        }

    }

    public static int maxDistance() {
        int max = 0;
        for (int i : distance) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

class Edge {
    int e;
    int w;

    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }
}