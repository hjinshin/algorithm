package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_2048_easy {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);
        System.out.println(max);
    }

    static void dfs(int[][] original, int count) {
        if (count >= 5) {
            findMax(original);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int[][] newBoard = copyBoard(original);
            if (k == 0) {
                // ->
                for (int i = 0; i < N; i++) {
                    int index = N - 1, block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (newBoard[i][j] != 0) {
                            if(block == newBoard[i][j]) {
                                newBoard[i][index + 1] = block * 2;
                                block = 0;
                                newBoard[i][j] = 0;
                            } else {
                                block = newBoard[i][j];
                                newBoard[i][j] = 0;
                                newBoard[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
            } else if (k == 1) {
                // <-
                for (int i = 0; i < N; i++) {
                    int index = 0, block = 0;
                    for (int j = 0; j < N; j++) {
                        if (newBoard[i][j] != 0) {
                            if (block == newBoard[i][j]) {
                                newBoard[i][index - 1] = block * 2;
                                block = 0;
                                newBoard[i][j] = 0;
                            } else {
                                block = newBoard[i][j];
                                newBoard[i][j] = 0;
                                newBoard[i][index] = block;
                                index++;
                            }
                        }
                    }
                }

            } else if (k == 2) {
                // ↑
                for (int i = 0; i < N; i++) {
                    int index = 0, block = 0;
                    for (int j = 0; j < N; j++) {
                        if (newBoard[j][i] != 0) {
                            if (block == newBoard[j][i]) {
                                newBoard[index - 1][i] = block * 2;
                                block = 0;
                                newBoard[j][i] = 0;
                            } else {
                                block = newBoard[j][i];
                                newBoard[j][i] = 0;
                                newBoard[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
            } else {
                // ↓
                for (int i = 0; i < N; i++) {
                    int index = N - 1, block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if(newBoard[j][i] != 0) {
                            if (block == newBoard[j][i]) {
                                newBoard[index + 1][i] = block * 2;
                                block = 0;
                                newBoard[j][i] = 0;
                            } else {
                                block = newBoard[j][i];
                                newBoard[j][i] = 0;
                                newBoard[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
            }

            dfs(newBoard, count + 1);
        }

    }

    static int[][] copyBoard(int[][] original) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, newBoard[i], 0, N);
        }
        return newBoard;
    }

    static void findMax(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }
    }
}
