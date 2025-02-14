package etc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24337_가희와_탑 {
    static int N, a, b;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
            list.add(i);
        }
        list.add(Math.max(a, b));
        for (int i = b - 1; i >= 1; i--) {
            list.add(i);
        }
        for (int i = list.size(); i < N; i++) {
            list.add(1, 1);
        }

        for (Integer i : list) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}
