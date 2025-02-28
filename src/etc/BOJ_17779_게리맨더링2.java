package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                for(int d1 = 1; d1 < N; d1++) {
                    for(int d2 = 1; d2 < N; d2++) {
                        if(y + d1 + d2 >= N) continue;
                        if(x + d2 >= N) continue;
                        if(x - d1 < 0) continue;
                        calculate(y, x, d1, d2);
                    }
                }
            }
        }

        System.out.println(min);
    }

    static void calculate(int y, int x, int d1, int d2) {
        int[] sum = new int[6];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i <= d1; i++) {
            visited[y + i][x - i] = true;
            visited[y + d2 + i][x + d2 - i] = true;
        }
        for(int i = 0; i < d2; i++) {
            visited[y + i][x + i] = true;
            visited[y + d1 + i][x - d1 + i] = true;
        }

        // sector 1
        for (int i = 0; i < y + d1; i++) {
            for (int j = 0; j <= x; j++) {
                if(visited[i][j]) break;
                sum[1] += arr[i][j];
            }
        }

        // sector 2
        for (int i = 0; i <= y + d2; i++) {
            for (int j = N - 1; j > x; j--) {
                if(visited[i][j]) break;
                sum[2] += arr[i][j];
            }
        }

        // sector 3
        for(int i = y + d1; i < N; i++) {
            for (int j = 0; j < x - d1 + d2; j++) {
                if(visited[i][j]) break;
                sum[3] += arr[i][j];
            }
        }

        // sector 4
        for(int i = y + d2 + 1; i < N; i++) {
            for(int j = N - 1; j >= x + d2 - d1; j--) {
                if(visited[i][j]) break;
                sum[4] += arr[i][j];
            }
        }

        // sector 5
        sum[5] = total;
        for (int i = 1; i <= 4; i++) {
            sum[5] -= sum[i];
        }

        min = Math.min(min, getMax(sum) - getMin(sum));
    }

    static int getMax(int[] arr) {
        int max = arr[1];
        for (int i = 2; i <= 5; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static int getMin(int[] arr) {
        int min = arr[1];
        for (int i = 2; i <= 5; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
