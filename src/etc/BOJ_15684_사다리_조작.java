package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684_사다리_조작 {
    static int N, M, H;
    static int[][] arr;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[a][b + 1] = -1;
        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, i, 0);
            if(result != -1) break;
        }

        System.out.println(result);
    }

    static void dfs(int row, int count, int depth) {
        if(result != -1) return;
        if (count == depth) {
            if(checkDest()) result = depth;
            return;
        }

        for (int i = row; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = 1;
                    arr[i][j + 1] = -1;
                    dfs(i, count, depth + 1);
                    arr[i][j] = 0;
                    arr[i][j + 1] = 0;
                }
            }
        }
    }

    static boolean checkDest() {
        for (int i = 1; i <= N; i++) {
            int y = 1, x = i;
            while (y <= H) {
                if (arr[y][x] == 1) {
                    x++;
                } else if (arr[y][x] == -1) {
                    x--;
                }
                y++;
            }
            if (x != i) {
                return false;
            }
        }
        return true;
    }
}
