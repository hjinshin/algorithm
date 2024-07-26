package ch9_tree.tree;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    static int N;
    static int[][] tree;
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new int[2][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stringToInt(st.nextToken());
            int left = stringToInt(st.nextToken());
            int right = stringToInt(st.nextToken());
            tree[0][u] = left;
            tree[1][u] = right;
        }

        preorder(0);
        result += "\n";
        inorder(0);
        result += "\n";
        postorder(0);
        bw.write(result);
        bw.flush();
        bw.close();
    }

    static void preorder(int c) {
        if(c == -1) return;
        result += intToChar(c);
        preorder(tree[0][c]);
        preorder(tree[1][c]);
    }

    static void inorder(int c) {
        if(c == -1) return;
        inorder(tree[0][c]);
        result += intToChar(c);
        inorder(tree[1][c]);
    }

    static void postorder(int c) {
        if(c == -1) return;
        postorder(tree[0][c]);
        postorder(tree[1][c]);
        result += intToChar(c);
    }

    static int stringToInt(String s) {
        if(Objects.equals(s, ".")) return -1;
        return s.charAt(0) - 'A';
    }

    static char intToChar(int i) {
        return (char) ('A' + i);
    }
}
