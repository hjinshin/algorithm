package ch9_tree.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10868_최솟값 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int height = getHeight(N);
        int arrSize = (int) Math.pow(2, height + 1);
        int startIndex = arrSize / 2;
        arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        for(int i=startIndex; i < startIndex + N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        setTree(arr.length - 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(findMin(a + startIndex - 1, b + startIndex - 1) + "\n");
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
            arr[i / 2] = Math.min(arr[i/2], arr[i]);
            i--;
        }
    }

    static int findMin(int start, int end) {
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                min = Math.min(min, arr[start]);
                start++;
            }
            if (end % 2 == 0) {
                min = Math.min(min, arr[end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return min;
    }
}
