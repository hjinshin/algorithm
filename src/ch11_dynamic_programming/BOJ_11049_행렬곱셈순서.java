package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_11049_행렬곱셈순서 {
    static int N;
    static int[][] DP;
    static Matrix[] M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1][N + 1];
        M = new Matrix[N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                DP[i][j] = -1;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            M[i] = new Matrix(x, y);
        }
        System.out.println(execute(1, N));
    }

    static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (DP[s][e] != -1) {
            return DP[s][e];
        }
        if (s == e) {
            return 0;
        }
        if (s + 1 == e) {
            return M[s].x * M[s].y * M[e].y;
        }
        for (int i = s; i < e; i++) {
            result = Math.min(result, M[s].x * M[i].y * M[e].y + execute(s, i) + execute(i + 1, e));
        }
        return DP[s][e] = result;
    }

    static class Matrix {
        int x, y;

        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
