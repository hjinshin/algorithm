package ch8_graph.floyd_warshall;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
    static int N;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        floyd();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i=1; i <= N; i++) {
                for (int j=1; j <= N; j++) {
                    if(dist[i][j] == 1) continue;
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
    }
}
