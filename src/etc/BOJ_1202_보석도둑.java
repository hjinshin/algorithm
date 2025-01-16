package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1202_보석도둑 {
    static int N, K;
    static long result;
    static PriorityQueue<Integer> cPQ = new PriorityQueue<>();
    static List<Jewel> jList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jList.add(new Jewel(m, v));
        }
        for (int i = 0; i < K; i++) {
            cPQ.add(Integer.parseInt(br.readLine()));
        }

        jList.sort(((o1, o2) -> {
            if (o1.m == o2.m) {
                return o2.v - o1.v;
            }
            return o1.m - o2.m;
        }));

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int idx = 0;
        while(!cPQ.isEmpty()) {
            int c = cPQ.poll();
            while (idx < N && jList.get(idx).m <= c) {
                pq.add(jList.get(idx++).v);
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    static class Jewel {
        int m, v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
