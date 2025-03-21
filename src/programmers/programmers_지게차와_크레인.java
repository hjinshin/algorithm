package programmers;

import java.util.*;

public class programmers_지게차와_크레인 {
    static final char NULL = '\u0000';
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    char[][] containers;
    int height, width;

    public int solution(String[] storage, String[] requests) {
        height = storage.length;
        width = storage[0].length();
        containers = new char[height + 2][width + 2];
        for(int i = 1; i <= height; i++) {
            char[] temp = storage[i - 1].toCharArray();
            for(int j = 1; j <= width; j++) {
                containers[i][j] = temp[j - 1];
            }
        }

        for(String s : requests) {
            if(s.length() == 1) {
                singleRequest(s.charAt(0));
            } else {
                doubleRequest(s.charAt(0));
            }
        }
        int answer = countContainers();
        return answer;
    }

    public void singleRequest(char c) {
        boolean[][] visited = new boolean[height + 2][width + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny < 0 || nx < 0 || ny > height + 1 || nx > width + 1) {
                    continue;
                }
                if(!visited[ny][nx] && (containers[ny][nx] == c || containers[ny][nx] == NULL)) {
                    if(containers[ny][nx] == NULL) {
                        queue.add(new int[] {ny, nx});
                    }
                    visited[ny][nx] = true;
                    containers[ny][nx] = NULL;
                }
            }
        }
    }

    public void doubleRequest(char c) {
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= width; j++) {
                if(containers[i][j] == c) {
                    containers[i][j] = NULL;
                }
            }
        }
    }

    public int countContainers() {
        int cnt = 0;
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= width; j++) {
                if(containers[i][j] != NULL) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void printAll() {
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= width; j++) {
                System.out.print(containers[i][j] + " ");
            }
            System.out.println();
        }
    }
}
