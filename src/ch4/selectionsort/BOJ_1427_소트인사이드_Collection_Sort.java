package ch4.selectionsort;

import java.io.*;
import java.util.*;

public class BOJ_1427_소트인사이드_Collection_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] strChar = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char c : strChar) {
            list.add(c - '0');
        }

        list.sort(Collections.reverseOrder());

        for (Integer i : list) {
            System.out.print(i);
        }
    }
}
