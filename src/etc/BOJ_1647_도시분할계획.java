package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
    static int N, M;
    static int result;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, w));
        }

        mst();
        System.out.println(result);
    }

    static void mst() {
        int count = 0;

        while(!pq.isEmpty() && count < N - 2) {
            Node cur = pq.poll();

            int a = find(cur.a);
            int b = find(cur.b);
            if (a != b) {
                union(a, b);
                count++;
                result += cur.w;
            }
        }
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    static class Node {
        int a, b, w;
        Node(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}
