package ch8.union_find;

import java.util.*;
import java.io.*;

public class BOJ_1043_거짓말 {
    static int N, M;
    static int[] parent;
    static List<Integer>[] participant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        participant = new List[M];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int knowTruth = Integer.parseInt(st.nextToken());
        for(int i=0; i < knowTruth; i++) {
            int k = Integer.parseInt(st.nextToken());
            parent[k] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            participant[i] = new ArrayList<>();
            for(int j=0; j < num; j++) {
                participant[i].add(Integer.parseInt(st.nextToken()));
            }
            party(num, participant[i]);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if(check(i)) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a ==0 || b == 0) {
            parent[a] = parent[b]  = 0;
        } else if (a != b) {
            parent[b] = a;
        }
    }

    public static boolean check(int i) {
        for (int person : participant[i]) {
            if (find(person) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void party(int num, List<Integer> participant) {
        for(int i=0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                union(participant.get(i), participant.get(j));
            }
        }
    }
}
