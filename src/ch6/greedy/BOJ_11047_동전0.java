package ch6.greedy;

import java.io.*;
import java.util.*;

public class BOJ_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        for(int i=coins.size() - 1; i >= 0; i--) {
            if(K >= coins.get(i)) {
                count += K / coins.get(i);
                K = K % coins.get(i);
            }
        }
        System.out.println(count);
    }
}
