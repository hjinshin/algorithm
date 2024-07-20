package ch4_sort.bubble_sort;

import java.io.*;
import java.util.*;

public class BOJ_2750_수정렬하기1_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pQueue.add(num);
        }

        while (!pQueue.isEmpty()) {
            bw.write(pQueue.poll() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
