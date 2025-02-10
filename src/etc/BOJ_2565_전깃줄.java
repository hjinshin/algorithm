package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄 {
    static int N, max;
    static int[] dp;
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.a - o2.a);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Pair(a, b));
            max = Math.max(max, Math.max(a, b));
        }
        dp = new int[max + 1];

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            dp[p.b]++;
            for (int i = p.b + 1; i <= max; i++) {
                if(dp[i] >= dp[i - 1]) break;
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(N - dp[max]);
    }

    static class Pair {
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}