package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static int N, L;
    static int[][] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            checkSlope(i, 0, 1);
            checkSlope(0, i, 0);
        }

        System.out.println(result);
    }

    static void checkSlope(int y, int x, int d) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 1; i < N; i++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(Math.abs(arr[ny][nx] - arr[y][x]) > 1) return;
            if (arr[ny][nx] > arr[y][x]) {
                for (int j = 0; j < L; j++) {
                    int by = y - dy[d] * j;
                    int bx = x - dx[d] * j;
                    if(by < 0 || bx < 0) return;
                    if(arr[by][bx] != arr[y][x]) return;
                    if(visited[by][bx]) return;
                    visited[by][bx] = true;
                }
            } else if (arr[ny][nx] < arr[y][x]) {
                for(int j = 0; j < L; j++) {
                    int nny = ny + dy[d] * j;
                    int nnx = nx + dx[d] * j;
                    if(nny >= N || nnx >= N) return;
                    if(arr[nny][nnx] != arr[ny][nx]) return;
                    if(visited[nny][nnx]) return;
                    visited[nny][nnx] = true;
                }
            }
            y = ny;
            x = nx;
        }

        result++;
    }
}