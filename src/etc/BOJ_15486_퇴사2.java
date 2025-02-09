package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {
    static int N;
    static Counsel[] list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new Counsel[N];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            list[i] = new Counsel(time, pay);
        }

        for (int i = N - 1; i >= 0; i--) {
            Counsel c = list[i];
            dp[i] = dp[i + 1];
            if (i + c.time <= N) {
                dp[i] = Math.max(dp[i], dp[i + c.time] + c.pay);
            }
        }
        System.out.println(dp[0]);
    }

    static class Counsel {
        int time, pay;
        Counsel(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }
    }
}