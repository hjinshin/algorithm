package ch5_search.dfs;

import java.io.*;

public class BOJ_2023_신기한소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(2, 1, N);
        dfs(3, 1, N);
        dfs(5, 1, N);
        dfs(7, 1, N);

    }

    public static void dfs(int num, int jarisu, int N) {
        if (jarisu == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, jarisu + 1, N);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
