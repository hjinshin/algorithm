package etc;

import java.io.*;
import java.util.*;

public class BOJ_1005_ACM_Craft {
    static int T, N, K;
    static List<Integer>[] graph;
    static int[] edges;
    static int[] times;
    static int[] builds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new List[N + 1];
            edges = new int[N + 1];
            times = new int[N + 1];
            builds = new int[N + 1];
            for(int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                edges[b]++;
            }

            int target = Integer.parseInt(br.readLine());
            topologicalSort();
            bw.write(builds[target] + times[target] + "\n");
        }
        bw.flush();
        br.close();
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (edges[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                edges[v]--;
                builds[v] = Math.max(builds[v], builds[u] + times[u]);
                if (edges[v] == 0) {
                    queue.add(v);
                }
            }
        }
    }
}
