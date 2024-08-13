package ch10_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251_조약돌 {
    static int M, N, K;
    static int[] D;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        D = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            N += D[i];
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            if (D[i] >= K) {
                double p = 1.0;
                for (int k = 0; k < K; k++) {
                    p *= (double) (D[i] - k) / (N - k);
                }
                result += p;
            }
        }
        System.out.println(result);
    }
}
