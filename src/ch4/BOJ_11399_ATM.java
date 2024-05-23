package ch4;

import java.io.*;
import java.util.*;

public class BOJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        A = Arrays.stream(A)
                .sorted()
                .toArray();
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
            result += A[i];
        }
        System.out.println(result);
    }
}
