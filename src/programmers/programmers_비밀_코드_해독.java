package programmers;

import java.util.*;

public class programmers_비밀_코드_해독 {
    int result;
    int length;
    int[] answer;
    Set<Integer>[] sets;

    public int solution(int n, int[][] q, int[] ans) {
        init(q, ans);
        dfs(new int[5], n, 0, 0);
        int answer = result;
        return answer;
    }

    public void init(int[][] q, int[] ans) {
        length = ans.length;
        answer = new int[length];
        sets = new Set[length];
        for(int i = 0; i < length; i++) {
            sets[i] = new HashSet<>();
            for(int j = 0; j < 5; j++) {
                sets[i].add(q[i][j]);
            }
        }

        for(int i = 0; i < length; i++) {
            answer[i] = ans[i];
        }
    }

    public void dfs(int[] arr, int n, int k, int depth) {
        if(depth == 5) {
            if(possible(arr)) {
                result += 1;
            }
            return;
        }

        for(int i = k + 1; i <= n; i++) {
            int[] newArr = copyArr(arr);
            newArr[depth] = i;
            dfs(newArr, n, i, depth + 1);
        }
    }

    public int[] copyArr(int[] arr) {
        int[] newArr = new int[5];
        for(int i = 0; i < 5; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public boolean possible(int[] arr) {
        for(int i = 0; i < length; i++) {
            int cnt = 0;
            for(int j = 0; j < 5; j++) {
                if(sets[i].contains(arr[j])) {
                    cnt++;
                }
            }
            if(cnt != answer[i]) return false;
        }
        return true;
    }
}