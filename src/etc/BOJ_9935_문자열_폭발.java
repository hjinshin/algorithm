package etc;

import java.io.*;
import java.util.Stack;

public class BOJ_9935_문자열_폭발 {
    static Stack<Character> stack = new Stack<>();
    static String str;
    static char[] bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        bomb = br.readLine().toCharArray();

        for(int i = str.length() - 1; i >= 0; i--) {
            stack.push(str.charAt(i));
            if (str.charAt(i) == bomb[0] && stack.size() >= bomb.length) {
                int idx = 0;
                for (int j = 0; j < bomb.length; j++) {
                    if (stack.peek() != bomb[j]) {
                        idx = j;
                        break;
                    }
                    stack.pop();
                }

                for (int j = idx - 1; j >= 0; j--) {
                    stack.push(bomb[j]);
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            while (!stack.isEmpty()) {
                bw.write(stack.pop());
            }
        }
        bw.flush();
        bw.close();
    }
}