package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398_연속된정수합 {
    static int[] A, R, L;
    static int N;
    static int Max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        R = new int[N];
        L = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        R[N - 1] = A[N - 1];
        L[0] = A[0];
        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1] + A[i], A[i]);
        }
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(L[i - 1] + A[i], A[i]);
        }

        for (int i = 0; i < N; i++) {
            Max = Math.max(Max, L[i]);
        }
        for (int i = 1; i < N - 1; i++) {
            Max = Math.max(Max, R[i + 1] + L[i - 1]);
        }
        System.out.println(Max);
    }
}
