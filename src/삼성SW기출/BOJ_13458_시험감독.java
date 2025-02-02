package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
    static int N, B, C;
    static int[] rooms;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        rooms = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            rooms[i] = rooms[i] - B;
            result += 1;
            if(rooms[i] <= 0)   continue;
            result += rooms[i] / C;
            if (rooms[i] % C != 0) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
