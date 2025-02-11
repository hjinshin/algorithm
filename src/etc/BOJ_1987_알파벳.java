package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int r, c;
    static char[][] arr;
    static boolean[] visited = new boolean[26];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }

        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int y, int x, int count) {
        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if (!visited[arr[ny][nx] - 'A']) {
                visited[arr[ny][nx] - 'A'] = true;
                dfs(ny, nx, count + 1);
                visited[arr[ny][nx] - 'A'] = false;
            }
        }
    }
}