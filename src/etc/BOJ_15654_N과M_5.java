package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M_5 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(arr[i] + " ", 1);
            visited[i] = false;
        }
    }

    static void dfs(String result, int cnt) {
        if (cnt == M) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(result + arr[i] + " ", cnt + 1);
                visited[i] = false;
            }
        }
    }
}