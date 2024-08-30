package ch6.greedy;

import java.io.*;
import java.util.*;

public class BOJ_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 1)      one++;
            else if(input == 0) zero++;
            else if(input > 1) plusPq.add(input);
            else minusPq.add(input);
        }

        while(plusPq.size() > 1) {
            int data1 = plusPq.poll();
            int data2 = plusPq.poll();
            total += data1 * data2;
        }
        while (!plusPq.isEmpty()) {
            total += plusPq.poll();
        }

        while(minusPq.size() > 1) {
            int data1 = minusPq.poll();
            int data2 = minusPq.poll();
            total += data1 * data2;
        }
        while(!minusPq.isEmpty() && zero == 0) {
            total += minusPq.poll();
        }
        total += one;
        System.out.println(total);
    }
}
