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
    static int result;

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
        boolean[] visited = new boolean[M * 2 + 1];
        pq.add(new int[]{N, 0});
        dp[N] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int time = cur[1];
            if(visited[now]) continue;
            visited[now] = true;

            if (now == K) {
                result = time;
                return;
            }

            if (now * 2 <= 2 * M && dp[now * 2] > dp[now]) {
                dp[now * 2] = dp[now];
                pq.add(new int[]{now * 2, time});
            }
            if (now + 1 <= 2 * M && dp[now + 1] > dp[now] + 1) {
                dp[now + 1] = dp[now] + 1;
                pq.add(new int[]{now + 1, time + 1});
            }
            if (now - 1 >= 0 && dp[now - 1] > dp[now] + 1) {
                dp[now - 1] = dp[now] + 1;
                pq.add(new int[]{now - 1, time + 1});
            }
        }
    }
}