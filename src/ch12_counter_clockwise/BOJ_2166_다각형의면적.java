package ch12_counter_clockwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {
    static int N;
    static long[] X;
    static long[] Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        X = new long[N];
        Y = new long[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        System.out.printf("%.1f%n", Math.abs(ccw()) / 2.0);

    }

    static long ccw() {
        long result = 0;
        for (int i = 0; i < N - 1; i++) {
            result += X[i] * Y[i + 1];
            result -= Y[i] * X[i + 1];
        }
        result += X[N - 1] * Y[0];
        result -= Y[N - 1] * X[0];
        return result;
    }
}
