package etc;

import java.io.*;

public class BOJ_15988_1_2_3_더하기_3 {
    static final int DIV = 1_000_000_009;
    static int T;
    static int[] arr;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        arr = new int[T];

        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        dp = new int[max + 1];
        dp[1] = dp[2] = dp[3] = 1;
        for(int i = 1; i < max; i++) {
            if(i + 1 > max) continue;
            dp[i + 1] = (dp[i] + dp[i + 1]) % DIV;
            if(i + 2 > max) continue;
            dp[i + 2] = (dp[i] + dp[i + 2]) % DIV;
            if (i + 3 > max) continue;
            dp[i + 3] = (dp[i] + dp[i + 3]) % DIV;
        }

        for (int i = 0; i < T; i++) {
            bw.write(dp[arr[i]] + "\n");
        }
        bw.flush();
        bw.close();
    }
}