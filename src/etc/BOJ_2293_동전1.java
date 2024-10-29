package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {
    static int N, K;
    static int[] DP;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        price = new int[N];
        DP = new int[K + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = price[i]; j <= K; j++) {
                DP[j] += DP[j - price[i]];
            }
        }

        System.out.println(DP[K]);
    }
}
