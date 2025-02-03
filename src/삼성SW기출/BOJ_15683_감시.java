package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15683_감시 {
        static int[] dy = {-1, 0, 1, 0};
        static int[] dx = {0, 1, 0, -1};
        static int N, M;
        static int min, count;
        static int[][] map;
        static List<CCTV> cctvs = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 0) count++;
                    else if(map[i][j] < 6) cctvs.add(new CCTV(j, i, map[i][j]));
                }
            }

            bfs();
            System.out.println(min);
        }

        static void bfs() {
            min = count;
            int cctvSize = cctvs.size();
            Queue<State> queue = new LinkedList<>();
            queue.add(new State(cloneMap(map), count, 0));

            while(!queue.isEmpty()) {
                State cur = queue.poll();
                if (cur.step == cctvSize) {
                    min = Math.min(cur.result, min);
                    continue;
                }
                CCTV cctv = cctvs.get(cur.step);

                for (int i = 0; i < cctv.spin; i++) {
                    int[][] tempMap = cloneMap(cur.map);
                    int nextResult = watch(tempMap, cctv, cur.result, i);
                    if (cctv.num == 2 || cctv.num == 4 || cctv.num == 5) {
                        nextResult = watch(tempMap, cctv, nextResult, (i + 2) % 4);
                    }
                    if (cctv.num == 3 || cctv.num == 4 || cctv.num == 5) {
                        nextResult = watch(tempMap, cctv, nextResult, (i + 1) % 4);
                    }
                    if (cctv.num == 5) {
                        nextResult = watch(tempMap, cctv, nextResult, (i + 3) % 4);
                    }

                    queue.add(new State(tempMap, nextResult, cur.step + 1));
                }

            }
        }

        static int watch(int[][] map, CCTV cctv, int result, int d) {
            int x = cctv.x;
            int y = cctv.y;
            while (true) {
                y += dy[d];
                x += dx[d];
                if(x < 0 || x >= M || y < 0 || y >= N) break;
                if(map[y][x] == 6) break;
                if(map[y][x] != 0) continue;
                map[y][x] = -1;
                result--;
            }
            return result;
        }

        static int[][] cloneMap(int[][] map) {
            int[][] newMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            return newMap;
        }

        static class State {
            int[][] map;
            int result, step;
            State(int[][] map, int result, int step) {
                this.map = map;
                this.result = result;
                this.step = step;
            }
        }

        static class CCTV {
            int y, x, num, spin;
            CCTV(int x, int y, int num) {
                this.x = x;
                this.y = y;
                this.num = num;
                this.spin = calcSpin(num);
            }

            int calcSpin(int num) {
                if (num == 1 || num == 3 || num == 4) {
                    return 4;
                } else if (num == 2) {
                    return 2;
                }
                return 1;
            }
        }
    }
