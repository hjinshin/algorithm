package ch4.radix_sort;

import java.io.*;

public class BOJ_10989_수정렬하기3_RadixSort {
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        radix_sort(5);
        for (int i : A) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radix_sort(int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count < max_size) {
            int[] bucket = new int[10];
            for (int i = 0; i < A.length; i++) {
                bucket[A[i] / jarisu % 10]++;
            }
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[A[i] / jarisu % 10] - 1] = A[i];
                bucket[A[i] / jarisu % 10]--;
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
            jarisu *= 10;
            count++;
        }
    }
}
