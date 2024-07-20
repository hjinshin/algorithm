package ch3_data_structure.two_pointer;

import java.util.*;
import java.io.*;

public class BOJ_1253_좋은수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int cnt = 0;

        for (int k = 0; k < N; k++) {
            int target = A[k];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                int sum = A[left] + A[right];
                if (target == sum) {
                    if (left != k && right != k) {
                        cnt++;
                        break;
                    } else if (left == k) {
                        left++;
                    } else if (right == k) {
                        right--;
                    }

                } else if (target > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
