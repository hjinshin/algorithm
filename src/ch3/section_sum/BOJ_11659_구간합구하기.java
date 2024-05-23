package ch3.section_sum;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);

        for (int i = 1; i <= n; i++) {
            arrayList.add(arrayList.get(i-1) + scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            System.out.println(arrayList.get(end) - arrayList.get(start-1));
        }
    }
}
