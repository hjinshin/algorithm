package ch3.queue;

import java.io.*;
import java.util.*;

public class BOJ_11286_절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            return first_abs - second_abs;
        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pQueue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pQueue.poll() + "\n");
                }
            } else {
                pQueue.add(input);
            }
        }

        bw.flush();
        bw.close();
    }
}
