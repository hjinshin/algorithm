package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기_설치 {
    static int N, C;
    static int result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);


        int min = 1;
        int max = arr[N - 1];
        while (min <= max) {
            int mid = (min + max) / 2;

            int cnt = 1;
            int pos = 0;
            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[pos] >= mid) {
                    pos = i;
                    cnt++;
                }
            }

            if (cnt < C) {
                max = mid - 1;
            } else {
                result = mid;
                min = mid + 1;
            }
        }

        System.out.println(result);
    }

}
