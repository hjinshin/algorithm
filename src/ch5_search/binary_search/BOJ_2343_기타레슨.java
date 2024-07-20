package ch5_search.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_2343_기타레슨 {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (start < A[i]) {
                start = A[i];
            }
            end += A[i];
        }
        int result = binarySearch(start, end);
        System.out.println(result);
    }

    public static int binarySearch(int start, int end) {
        while (start <= end) {
            int count = 0;
            int sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (mid < sum + A[i]) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
