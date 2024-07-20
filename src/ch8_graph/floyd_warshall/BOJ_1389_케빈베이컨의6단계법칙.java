package ch8_graph.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
    final static int INF = 1000001;
    static int N, M;
    static int[][] dist;
    static int[] kevinBacon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        kevinBacon = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for(int j=1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else        dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1;
            dist[B][A] = 1;
        }
        floyd();
        sumBacon();
        System.out.println(getMinBacon());
    }

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for(int i=1; i <= N; i++) {
                for(int j=1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    static void sumBacon() {
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= N; j++) {
                kevinBacon[i] += dist[i][j];
            }
        }
    }

    static int getMinBacon() {
        int min = 1;
        for (int i = 2; i <= N; i++) {
            if (kevinBacon[min] > kevinBacon[i]) {
                min = i;
            }
        }
        return min;
    }
}
