package ch9_tree.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {
    static int N, M, K;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int height = getHeight(N);
        int arrSize = (int) Math.pow(2, height + 1);
        int startIndex = arrSize / 2;
        arr = new long[arrSize];

        for (int i = startIndex; i < startIndex + N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        setTree(arr.length - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                updateTree((int)(b + startIndex - 1), c);
            } else {
                bw.write(sumTree((int)(b + startIndex - 1), (int)(c + startIndex - 1)) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static int getHeight(int length) {
        int height = 0;
        while (length != 0) {
            length /= 2;
            height++;
        }
        return height;
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
