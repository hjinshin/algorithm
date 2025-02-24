package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4179_불 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int R, C;
    static char[][] map;
    static Queue<int[]> fires = new LinkedList<>();
    static Queue<int[]> jihuns = new LinkedList<>();
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    jihuns.add(new int[]{i, j});
                } else if (map[i][j] == 'F') {
                    fires.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    static String bfs() {

        while (true) {
            time++;
            List<int[]> newFires = new ArrayList<>();
            List<int[]> newJihuns = new ArrayList<>();

            while (!jihuns.isEmpty()) {
                int[] jihun = jihuns.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = jihun[0] + dy[i];
                    int nx = jihun[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        return time + "";
                    }
                    if (map[ny][nx] != '.') continue;
                    map[ny][nx] = 'J';
                    newJihuns.add(new int[]{ny, nx});
                }
            }

            while (!fires.isEmpty()) {
                int[] fire = fires.poll();
                for (int i = 0; i < 4; i++) {
                    int fy = fire[0] + dy[i];
                    int fx = fire[1] + dx[i];
                    if(fy < 0 || fx < 0 || fy >= R || fx >= C) continue;
                    if(map[fy][fx] == '#' || map[fy][fx] == 'F') continue;
                    newFires.add(new int[]{fy, fx});
                    map[fy][fx] = 'F';
                }
            }

            int jihunSize = newJihuns.size();
            for (int i = 0; i < jihunSize; i++) {
                int[] jihun = newJihuns.get(i);
                if (map[jihun[0]][jihun[1]] != 'J') {
                    newJihuns.remove(jihun);
                    i--; jihunSize--;
                }
            }
            for(int i = 0; i < newJihuns.size(); i++) {
                int[] jihun = newJihuns.get(i);
                if (map[jihun[0]][jihun[1]] == 'J') {
                    jihuns.add(jihun);
                }
            }
            fires.addAll(newFires);
            if (jihuns.isEmpty()) {
                break;
            }
        }
        return "IMPOSSIBLE";
    }
}