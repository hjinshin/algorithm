package etc;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1244_스위치_켜고_끄기 {
    static int N, studentCnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        studentCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if (sex == 1) {
                boySwitch(idx);
            } else {
                girlSwitch(idx);
            }
        }
        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + " ");
            if (i % 20 == 0) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void boySwitch(int start) {
        int idx = start;
        while (idx <= N) {
            arr[idx] ^= 1;
            idx += start;
        }
    }

    static void girlSwitch(int start) {
        arr[start] ^= 1;
        int w = 1;
        while (start - w > 0 && start + w <= N) {
            if (arr[start - w] != arr[start + w]) {
                break;
            }
            arr[start - w] ^= 1;
            arr[start + w] ^= 1;
            w++;
        }
    }
}