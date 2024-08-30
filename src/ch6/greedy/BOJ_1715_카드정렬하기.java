package ch6.greedy;

import java.io.*;
import java.util.*;

public class BOJ_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int data1 = 0;
        int data2 = 0;
        while (pq.size() > 1) {
            data1 = pq.poll();
            data2 = pq.poll();
            int sum = data1 + data2;
            total += sum;
            pq.add(sum);
        }
        System.out.println(total);
    }
}
