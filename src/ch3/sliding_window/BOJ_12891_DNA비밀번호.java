package ch3.sliding_window;

import java.io.*;
import java.util.*;

public class BOJ_12891_DNA비밀번호 {
    static final char[] DNA_CHAR = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        String str = br.readLine();
        char[] strChar = str.toCharArray();

        int[] dna = new int[4]; // A C G T
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int left = 0;
        int right = left + P - 1;
        int[] myArr = new int[4];
        for (int i = left; i <= right; i++) {
            addChar(strChar, myArr, i);
        }

        while (right < S) {
            if (checkPasswd(dna, myArr)) {
                count++;
            }
            if (right == S-1) {
                break;
            }
            addChar(strChar, myArr, right+1);
            removeChar(strChar, myArr, left);
            right++;
            left++;
        }
        System.out.println(count);
    }

    public static void addChar(char[] strChar, int[] myArr, int i) {
        if (strChar[i] == DNA_CHAR[0]) {
            myArr[0]++;
        } else if (strChar[i] == DNA_CHAR[1]) {
            myArr[1]++;
        } else if (strChar[i] == DNA_CHAR[2]) {
            myArr[2]++;
        } else if (strChar[i] == DNA_CHAR[3]) {
            myArr[3]++;
        }
    }

    public static void removeChar(char[] strChar, int[] myArr, int i) {
        if (strChar[i] == DNA_CHAR[0]) {
            myArr[0]--;
        } else if (strChar[i] == DNA_CHAR[1]) {
            myArr[1]--;
        } else if (strChar[i] == DNA_CHAR[2]) {
            myArr[2]--;
        } else if (strChar[i] == DNA_CHAR[3]) {
            myArr[3]--;
        }
    }

    public static boolean checkPasswd(int[] dna, int[] myArr) {
        return (dna[0] <= myArr[0]) && (dna[1] <= myArr[1]) && (dna[2] <= myArr[2]) && (dna[3] <= myArr[3]);
    }
}