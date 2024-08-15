package ch11_dynamic_programming;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9252_LCS {
    static long[][] DP;
    static char[] A1, A2;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        A1 = str1.toCharArray();

        st = new StringTokenizer(br.readLine());
        String str2 = st.nextToken();
        A2 = str2.toCharArray();

        DP = new long[A1.length + 1][A2.length + 1];
        for (int i = 1; i <= A1.length; i++) {
            for (int j = 1; j <= A2.length; j++) {
                if (A1[i - 1] == A2[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j]);
                }
            }
        }

        bw.write(DP[A1.length][A2.length] + "\n");
        int x = A2.length;
        int y = A1.length;

        while (DP[y][x] != 0) {
            if (DP[y - 1][x] == DP[y][x]) {
                y--;
            } else if (DP[y][x - 1] == DP[y][x]) {
                x--;
            } else {
                stack.push(A2[x - 1]);
                x--;
                y--;
            }
        }

        while(!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
    }
}
