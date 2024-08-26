package ch12_counter_clockwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11758_CCW {
    static int[] X = new int[3];
    static int[] Y = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        if (ccw() > 0) {
            System.out.println(1);
        } else if (ccw() == 0) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }

    }

    static int ccw() {
        return (X[0] * Y[1] + X[1] * Y[2] + X[2] * Y[0]) - (Y[0] * X[1] + Y[1] * X[2] + Y[2] * X[0]);
    }
}
