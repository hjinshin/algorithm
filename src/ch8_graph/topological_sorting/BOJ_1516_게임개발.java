package ch8_graph.topological_sorting;

import java.io.*;
import java.util.*;

public class BOJ_1516_게임개발 {
    static int N;
    static List<Integer>[] graph;
    static int[] edges;
    static int[] times;
    static int[] builds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        edges = new int[N + 1];
        times = new int[N + 1];
        builds = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if(num==-1) break;
                graph[num].add(i);
                edges[i]++;
            }
        }
        topologicalSort();
        for(int i=1; i<=N; i++) {
            bw.write((builds[i] + times[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(edges[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph[u]) {
                edges[v]--;
                builds[v] = Math.max(builds[v], builds[u] + times[u]);
                if(edges[v] == 0) {
                    queue.add(v);
                }
            }
        }
    }
}
