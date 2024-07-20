package ch8_graph.union_find;

import java.util.*;
import java.io.*;

public class BOJ_1976_여행가자 {
    static int N, M;
    static int[] parent;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        plan = new int[M];
        for(int i=1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        String answer = "YES";
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (!check(start, target)) {
                answer = "NO";
                break;
            }
            start = target;
        }
        System.out.println(answer);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(parent[x] != parent[y]) {
            parent[y] = x;
        }
    }

    static boolean check(int x, int y) {
        x = find(x);
        y = find(y);
        return parent[x] == parent[y];
    }
}
