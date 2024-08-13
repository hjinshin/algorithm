package ch10_combination;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
    static final int MAX = 30;
    static long[][] DP = new long[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < MAX; i++) {
            DP[i][i] = 1;
            DP[i][0] = 1;
            DP[i][1] = i;
        }

        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j < MAX; j++) {
                DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int t = T; t > 0; t--) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            bw.write(DP[M][N] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
