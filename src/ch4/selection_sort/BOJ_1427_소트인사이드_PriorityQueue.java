package ch4.selection_sort;

import java.io.*;
import java.util.*;

public class BOJ_1427_소트인사이드_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] strChar = str.toCharArray();

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (char c : strChar) {
            pQueue.add(c - '0');
        }

        while (!pQueue.isEmpty()) {
            System.out.print(pQueue.poll());
        }
    }
}
