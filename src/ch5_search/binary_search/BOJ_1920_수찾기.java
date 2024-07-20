package ch5_search.binary_search;

import java.io.*;
import java.util.*;

public class BOJ_1920_수찾기 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            int result = binarySearch(x);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int binarySearch(int x) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(x == A[mid]) {
                return 1;
            }
            if(x < A[mid]) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        return 0;
    }
}

