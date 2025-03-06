package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
    static int N, K;
    static int M;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Math.max(N, K);
        dp = new int[M * 2 + 1];

        for (int i = 0; i <= M * 2; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        bfs();
        System.out.println(dp[K]);
    }

    static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{N, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dp[cur[0]] <= cur[1]) {
                continue;
            }
            dp[cur[0]] = cur[1];
            if(cur[0] == K) return;

            if (cur[0] * 2 <= 2 * M) {
                pq.add(new int[]{cur[0] * 2, cur[1]});
            }
            if (cur[0] + 1 <= 2 * M) {
                pq.add(new int[]{cur[0] + 1, cur[1] + 1});
            }
            if (cur[0] - 1 >= 0) {
                pq.add(new int[]{cur[0] - 1, cur[1] + 1});
            }
        }
    }
}