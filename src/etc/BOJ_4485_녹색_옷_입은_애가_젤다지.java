package etc;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int N;
    static int[][] arr;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            bw.write("Problem " + cnt++ + ": " + min + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.sum - o2.sum));
        pq.add(new Node(0, 0, arr[0][0]));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.y == N - 1 && node.x == N - 1) {
                min = node.sum;
                break;
            }

            if(visited[node.y][node.x]) continue;
            visited[node.y][node.x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(!visited[ny][nx]) {
                    pq.add(new Node(ny, nx, node.sum + arr[ny][nx]));
                }
            }
        }
    }

    static class Node {
        int y, x, sum;
        Node(int y, int x, int sum) {
            this.y = y;
            this.x = x;
            this.sum = sum;
        }
    }
}
