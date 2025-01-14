package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2239_스도쿠 {
    static int[][] board;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            char[] chs = st.nextToken().toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = chs[j] - '0';
            }
        }
        dfs(0, 0);

        printBoard();
    }

    static void dfs(int row, int col) {
        if(row >= 8 && col > 8) {
            flag = true;
            return;
        }
        if (col > 8) {
            row++;
            col = 0;
        }


        if(board[row][col] != 0) {
            dfs(row, col + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!existsAtRow(row, i) && !existsAtCol(col, i) && !existsAtSquare(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);

                    if(flag) return;
                    board[row][col] = 0;
                }
            }
        }
    }

    static boolean existsAtRow(int row, int target) {
        for (int i : board[row]) {
            if(i == target) return true;
        }
        return false;
    }

    static boolean existsAtCol(int col, int target) {
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == target) return true;
        }
        return false;
    }

    static boolean existsAtSquare(int row, int col, int target) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == target) return true;
            }
        }
        return false;
    }

    static void printBoard() {
        for (int[] line : board) {
            for (int i : line) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}