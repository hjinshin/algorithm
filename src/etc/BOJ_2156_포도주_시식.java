package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주_시식 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 3];
        dp = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 3; i < N + 3; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[N + 2]);
    }
}
