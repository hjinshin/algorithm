package ch3.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int idx = stack.pop();
                result[idx] = A[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }

        for (int i : result) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}
