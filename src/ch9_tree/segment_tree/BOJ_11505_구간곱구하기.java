package ch9_tree.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11505_구간곱구하기 {
    static long MOD = 1_000_000_007;
    static int N, M, K;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int arrSize = getTreeSize();
        int startIndex = arrSize / 2;
        arr = new long[arrSize];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = startIndex; i < startIndex + N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        setTree(arr.length - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                updateTree(b + startIndex - 1, c);
            } else {
                bw.write(getMul(b + startIndex - 1, (int)(c + startIndex - 1)) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        return (int) Math.pow(2, h+1);
    }

    static void setTree(int i) {
        while (i != 1) {
            arr[i / 2] = arr[i / 2] * arr[i] % MOD;
            i--;
        }
    }

    static void updateTree(int index, long x) {
        arr[index] = x;
        while(index > 1) {
            index /= 2;
            arr[index] = arr[index * 2] % MOD * arr[index * 2 + 1] % MOD;
        }
    }

    static long getMul(int start, int end) {
        long mul = 1;
        while(start <= end) {
            if (start % 2 == 1) {
                mul = mul * arr[start] % MOD;
                start++;
            }
            if (end % 2 == 0) {
                mul = mul * arr[end] % MOD;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return mul;
    }
}
