package ch9_tree.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1068_리프노드개수구하기 {
    static int N;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int root;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new List[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }
        int delete = Integer.parseInt(br.readLine());
        visited[delete] = true;
        dfs(root);

        System.out.println(result);
    }

    static void dfs(int u) {
        if (visited[u]) return;

        int count = 0;
        visited[u] = true;
        for (Integer v : tree[u]) {
            if(!visited[v]) {
                count++;
                dfs(v);
            }
        }
        if (count == 0) {
            result++;
        }
    }
}
