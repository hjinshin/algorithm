package ch10_combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1722_순열 {
    static int N;
    static long K;
    static int[] S;
    static long[] F;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        S = new int[N + 1];
        F = new long[N + 1];
        visited = new boolean[N + 1];

        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());

        if (C == 1) {
            K = Long.parseLong(st.nextToken());

            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (K <= cnt * F[N - i]) {
                        K -= ((cnt - 1) * F[N - i]);
                        visited[j] = true;
                        System.out.print(j + " ");
                        break;
                    }
                    cnt++;
                }
            }
        } else {
            K = 1;
            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (!visited[j]) {
                        cnt++;
                    }
                }
                K += cnt * F[N - i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
    }
}