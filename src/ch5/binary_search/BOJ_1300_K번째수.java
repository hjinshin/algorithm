package ch5.binary_search;

import java.io.*;

public class BOJ_1300_K번째수 {
    static int N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int result = binarySearch(1, k);
        System.out.println(result);
    }

    public static int binarySearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }
            if (k > cnt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
