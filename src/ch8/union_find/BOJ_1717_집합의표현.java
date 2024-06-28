package ch8.union_find;

import java.io.*;
import java.util.*;

public class BOJ_1717_집합의표현 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int op, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                union(a, b);
            } else if (op == 1) {
                bw.write(checkSame(a, b) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static String checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (parent[a] == parent[b]) {
            return "YES";
        }
        return "NO";
    }
}