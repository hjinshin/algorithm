package etc;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
    static int N;
    static int[] arr;
    static int[] result;
    static int max;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        result = new int[N + 1];
        st = new StringTokenizer((br.readLine()));
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
                stack.clear();
                stack.push(i);
                bw.write("0 ");
            } else {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    stack.pop();
                }
                bw.write(stack.peek() + " ");
                stack.push(i);
            }
        }
        bw.flush();
        bw.close();
    }
}