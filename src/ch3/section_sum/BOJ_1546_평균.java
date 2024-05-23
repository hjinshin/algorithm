package ch3.section_sum;

import java.util.Scanner;

public class BOJ_1546_평균 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];
        int max = 0;
        long sum = 0;
        double result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }

        result = (double) sum / max * 100 / N;
        System.out.println(result);
    }
}
