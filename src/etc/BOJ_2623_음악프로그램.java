package etc;

import java.io.*;
import java.util.*;

public class BOJ_2623_음악프로그램 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] lines;
    static Queue<Integer> resultQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        lines = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num - 1; j++) {
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                lines[v]++;
                u = v;
            }
        }

        topologicalSort();

        if (resultQueue.size() < N) {
            bw.write("0");
        } else {
            while (!resultQueue.isEmpty()) {
                bw.write(resultQueue.poll() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (lines[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            resultQueue.add(u);
            for (int v : graph[u]) {
                lines[v]--;
                if(lines[v] == 0) {
                    queue.add(v);
                }
            }
        }
    }
}
