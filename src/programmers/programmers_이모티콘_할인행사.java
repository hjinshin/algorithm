package programmers;

import java.util.*;

public class programmers_이모티콘_할인행사 {
    int[] discountRate = {10, 20, 30, 40};
    List<List<Integer>> combs = new ArrayList<>();
    int cnt;
    int total;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(new ArrayList<>(), emoticons.length, 0);

        for(List<Integer> comb : combs) {
            calc(users, emoticons, comb);
        }
        int[] answer = {cnt, total};
        return answer;
    }

    void dfs(List<Integer> list, int maxDepth, int depth) {
        if(depth >= maxDepth) {
            combs.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < 4; i++) {
            list.add(discountRate[i]);
            dfs(list, maxDepth, depth + 1);
            list.remove(depth);
        }

    }

    void calc(int[][] users, int[] emoticons, List<Integer> eList) {
        int stotal = 0;
        int pCnt = 0;
        for(int[] user : users) {
            int rate = user[0];
            int limit = user[1];
            int sum = 0;
            for(int i = 0; i < eList.size(); i++) {
                if(eList.get(i) >= rate) {
                    sum += emoticons[i] * (100 - eList.get(i)) / 100;
                    if(sum >= limit) {
                        sum = 0;
                        pCnt++;
                        break;
                    }
                }
            }
            stotal += sum;
        }

        if(pCnt > cnt) {
            cnt = pCnt;
            total = stotal;
        } else if(pCnt == cnt && stotal > total) {
            total = stotal;
        }
    }
}