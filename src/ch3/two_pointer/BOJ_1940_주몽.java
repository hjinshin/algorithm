package ch3.two_pointer;

import java.util.*;
import java.io.*;

public class BOJ_1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int pivot1 = 0;
        int pivot2 = N - 1;
        while (pivot1 < pivot2) {
            int sum = arr[pivot1] + arr[pivot2];
            if (sum == M) {
                cnt++;
                pivot1++;
                pivot2--;
            } else if (sum < M) {
                pivot1++;
            } else {
                pivot2--;
            }
        }
        System.out.println(cnt);
    }
}
