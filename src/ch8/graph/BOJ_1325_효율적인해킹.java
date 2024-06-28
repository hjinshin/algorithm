package ch8.graph;

import java.io.*;
import java.util.*;

public class BOJ_1325_효율적인해킹 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] dis_result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        dis_result = new int[N + 1];
        for(int i=0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dis_result[i]);
        }
        for (int i = 1; i <= N; i++) {
            if(max == dis_result[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited = new boolean[N + 1];
        visited[start] = true;
        dis_result[start]++;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer i : graph[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    dis_result[start]++;
                    queue.add(i);
                }
            }
        }
    }
}