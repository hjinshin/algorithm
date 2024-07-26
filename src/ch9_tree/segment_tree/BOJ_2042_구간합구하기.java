package ch9_tree.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {
    static int N, M, K;
    static long[] arr;
    static List<Long> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[2 * N];
        result = new ArrayList<>();

        for (int i = N; i < 2 * N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        setTree(arr.length - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                updateTree((int)(b + N - 1), c);
            } else {
                result.add(sumTree((int)(b + N - 1), (int)(c + N - 1)));
            }
        }

        for (Long l : result) {
            System.out.println(l);
        }
    }

    static void setTree(int i) {
        while (i > 1) {
            arr[i / 2] += arr[i];
            i--;
        }
    }

    static void updateTree(int index, long x) {
        long diff = arr[index] - x;
        while (index > 0) {
            arr[index] -= diff;
            index /= 2;
        }
    }

    static long sumTree(int start, int end) {
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += arr[start];
                start++;
            }
            if (end % 2 == 0) {
                sum += arr[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return sum;

    }
}
