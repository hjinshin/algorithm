package ch4.bubble_sort;

import java.io.*;
import java.util.*;

// Collectios.sort()는 TimSort 방식으로 삽입정렬과 합병정렬을 결합한 정렬
// Collectios.sort() [시간복잡도 평균, 최악 : O(nlog(n))] 는
// Arrays.sort()의 QuickSort() [시간복잡도 평균 : O(nlog(n)) / 최악 : O(n^2)] 보다 빠르다.
public class BOJ_2750_수정렬하기1_Collections_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }

        A.sort(Comparator.naturalOrder());

        for (int i : A) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}
