package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
    static int N;
    static int[] A;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        int[] op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, A[0], op);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int value, int[] op) {
        if (idx == N) {
            if(max < value) max = value;
            if(min > value) min = value;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i]--;

            if (i == 0) {
                dfs(idx+1, value + A[idx], op);
            } else if (i == 1) {
                dfs(idx+1, value - A[idx], op);
            } else if (i == 2) {
                dfs(idx+1, value * A[idx], op);
            } else {
                dfs(idx+1, value / A[idx], op);
            }
            op[i]++;
        }
    }
}
