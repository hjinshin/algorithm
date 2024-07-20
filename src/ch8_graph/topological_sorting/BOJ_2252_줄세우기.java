package ch8_graph.topological_sorting;

import java.util.*;
import java.io.*;

public class BOJ_2252_줄세우기 {
    static int N, M;
    static int[] edges;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] =  new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            edges[B]++;
        }
        topologicalSort();
    }

    public static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (edges[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (Integer v : graph[u]) {
                edges[v]--;
                if(edges[v] == 0) {
                    queue.add(v);
                }
            }
        }
    }
}
