package ch4.merge_sort;

import java.io.*;

public class BOJ_2751_수정렬하기2 {
    public static int[] A, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, N-1);

        for (int i : A) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void merge_sort(int s, int e) {
        if(e - s < 1)   return;

        int m = s + (e - s) / 2;

        merge_sort(s, m);
        merge_sort(m+1, e);

        for (int i = s; i <= e; i++) {
            temp[i] = A[i];
        }
        int idx1 = s;
        int idx2 = m+1;
        int k = s;

        while (idx1 <= m && idx2 <= e) {
            if (temp[idx1] > temp[idx2]) {
                A[k] = temp[idx2];
                idx2++;
            } else {
                A[k] = temp[idx1];
                idx1++;
            }
            k++;
        }
        while (idx1 <= m) {
            A[k] = temp[idx1];
            idx1++;
            k++;
        }
        while (idx2 <= e) {
            A[k] = temp[idx2];
            idx2++;
            k++;
        }
    }
}
