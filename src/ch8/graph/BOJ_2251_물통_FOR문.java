package ch8.graph;

import java.util.*;
import java.io.*;

public class BOJ_2251_물통_FOR문 {
    static int[] capacity = new int[3];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[capacity[0] + 1][capacity[1] + 1][capacity[2] + 1];

        bfs(0, 0, capacity[2]);

        while (!pq.isEmpty()) {
            int x = pq.poll();
            bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int s_A, int s_B, int s_C) {
        Queue<int[]> q = new LinkedList<>();
        visited[s_A][s_B][s_C] = true;
        q.add(new int[]{s_A, s_B, s_C});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == 0) {
                pq.add(now[2]);
            }
            for (int i = 0; i < 2; i++) {
                for (int j = i+1; j < 3; j++) {
                    int[] next = pour(now, i, j);
                    if(!visited[next[0]][next[1]][next[2]]) {
                        visited[next[0]][next[1]][next[2]] = true;
                        q.add(new int[]{next[0], next[1], next[2]});
                    }
                    next = pour(now, j, i);
                    if(!visited[next[0]][next[1]][next[2]]) {
                        visited[next[0]][next[1]][next[2]] = true;
                        q.add(new int[]{next[0], next[1], next[2]});
                    }
                }
            }
        }
    }

    public static int[] pour(int[] bucket, int source, int target) {
        int[] next = new int[]{bucket[0], bucket[1], bucket[2]};
        int limit = capacity[target] - bucket[target];
        int left = bucket[source];
        int move = Math.min(limit, left);

        next[target] += move;
        next[source] -= move;
        return next;
    }
}
