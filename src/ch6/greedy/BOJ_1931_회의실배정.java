package ch6.greedy;

import java.io.*;
import java.util.*;

public class BOJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            int first_start = o1.start;
            int first_end = o1.end;
            int second_start = o2.start;
            int second_end = o2.end;
            if(first_end == second_end)
                return first_start - second_start;
            return first_end - second_end;
        });

        int count = 0;
        int pivot = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(start, end));
        }

        while(!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (meeting.start >= pivot) {
                count++;
                pivot = meeting.end;
            }
        }
        System.out.println(count);
    }
}
class Meeting {
    int start;
    int end;
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
