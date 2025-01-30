package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        before = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            before[b]++;
        }

        topologicalSort();
    }

    static void topologicalSort() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i < N + 1; i++) {
            if(before[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for(int v : graph[u]) {
                before[v]--;
                if(before[v] == 0) queue.add(v);
            }
        }
    }
}
