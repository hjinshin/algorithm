package ch8.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17472_다리만들기2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static int islandNum;
    static boolean[][] visited;
    static int[] parent;
    static List<int[]> islandNodes = new ArrayList<>();
    static PriorityQueue<Edge> edgePQ;
    static int edgeCount, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited =  new boolean[N][M];
        edgePQ = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    map[i][j] = x;
                    islandNodes.add(new int[]{i, j});
                }
            }
        }
        numbering();
        findBridges();
        mst();

        if (edgeCount < islandNum - 1) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    static void numbering() {
        for (int[] islandNode : islandNodes) {
            int i = islandNode[0];
            int j = islandNode[1];
            if (!visited[i][j]) {
                islandNum++;
                bfs(i, j);
            }
        }
    }

    static void findBridges() {
        for (int[] islandNode : islandNodes) {
            int i = islandNode[0];
            int j = islandNode[1];

            for (int d = 0; d < 4; d++) {
                int nx = i + dx[d];
                int ny = j + dy[d];
                int bridgeLength = 0;
                while(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(map[nx][ny] != 0) break;
                    bridgeLength++;
                    nx += dx[d];
                    ny += dy[d];
                }
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] != 0 && bridgeLength >= 2) {
                    edgePQ.add(new Edge(map[i][j], map[nx][ny], bridgeLength));
                }
            }
        }
    }

    static void mst() {
        parent = new int[islandNum + 1];
        for (int i = 0; i <= islandNum; i++) {
            parent[i] = i;
        }
        while (!edgePQ.isEmpty()) {
            Edge e = edgePQ.poll();
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                edgeCount++;
                result += e.w;
            }
        }
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = islandNum;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int s_i = node[0];
            int s_j = node[1];
            for (int d = 0; d < 4; d++) {
                int nx = s_i + dx[d];
                int ny = s_j + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                map[nx][ny] = islandNum;
                visited[nx][ny] = true;
            }
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}