package ch10_combination;

import java.io.*;

public class BOJ_2775_부녀회장 {
    static final int MAX = 14;
    static int[][] apartment = new int[MAX + 1][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < MAX + 1; i++) {
            apartment[0][i] = i;
        }

        for(int i=1; i < MAX + 1; i++) {
            for(int j=1; j < MAX + 1; j++) {
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(apartment[k][n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
