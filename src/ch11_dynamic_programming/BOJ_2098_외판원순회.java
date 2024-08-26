package ch11_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2098_외판원순회 {
    static final int INF = 16 * 1_000_000;
    static int N;
    static int[][] W;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        D = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }

    static int tsp(int now, int visit) {
        if (visit == (1 << N) - 1) {
            // 모든 노드 방문 시
            if (W[now][0] == 0) return INF;
            return W[now][0];
        }
        if (D[now][visit] != 0) {
            // 이미 방문한 노드
            return D[now][visit];
        }
        D[now][visit] = INF;
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && W[now][i] != 0) {
                // 방문한 적 없고, 갈 수 있는 도시일 때
                D[now][visit] = Math.min(D[now][visit], tsp(i, (visit | (1 << i))) + W[now][i]);
            }
        }
        return D[now][visit];
    }
}
