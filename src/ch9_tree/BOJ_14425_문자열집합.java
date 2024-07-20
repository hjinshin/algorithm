package ch9_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14425_문자열집합 {
    static int N, M;
    static int count;
    static Node root = new Node();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            Node now = root;
            for (int c = 0; c < arr.length; c++) {
                int index = arr[c] - 'a';
                if (now.next[index] == null) {
                    now.next[index] = new Node();
                }
                now = now.next[index];
                if (c == arr.length - 1) {
                    now.isEnd = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            char[] arr = br.readLine().toCharArray();
            Node now = root;
            for (int c = 0; c < arr.length; c++) {
                int index = arr[c] - 'a';
                if (now.next[index] == null) {
                    break;
                }
                now = now.next[index];
                if (now.isEnd && c == arr.length - 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}
