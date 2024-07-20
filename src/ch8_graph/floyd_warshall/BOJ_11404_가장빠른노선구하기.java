package ch8_graph.floyd_warshall;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11404_가장빠른노선구하기 {
    static int MAX = 10000001;
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) dist[i][j] = 0;
                else       dist[i][j] = MAX;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        Floyd();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] == MAX)    bw.write("0 ");
                else                    bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void Floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
