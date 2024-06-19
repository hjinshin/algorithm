package ch4.selection_sort;

import java.io.*;

public class BOJ_1427_소트인사이드_Selection_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] strChar = str.toCharArray();

        for (int i = 0; i < strChar.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < strChar.length; j++) {
                if (strChar[max] - '0' < strChar[j] - '0') {
                    max = j;
                }
            }
            char temp = strChar[i];
            strChar[i] = strChar[max];
            strChar[max] = temp;
        }

        for (char c : strChar) {
            System.out.print(c);
        }
    }
}
