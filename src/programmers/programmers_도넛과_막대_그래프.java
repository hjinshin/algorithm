package programmers;

import java.util.*;

class programmers_도넛과_막대_그래프 {
    List<Integer>[] nextList;
    int[] before;
    int length;
    int[] result = new int[4];

    public int[] solution(int[][] edges) {
        length = findMax(edges) + 1;
        nextList = new List[length];
        before = new int[length];
        for(int i = 0; i < length; i++) {
            before[i] = -1;
        }

        for(int i = 0; i < length; i++) {
            nextList[i] = new ArrayList<>();
        }
        setTarget(edges);

        for(int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            nextList[source].add(dest);
            before[dest] += 1;
        }

        findGenNode();

        for(Integer next : nextList[result[0]]) {
            before[next] -= 1;
        }

        for(int i = 1; i < length; i++) {
            if(i == result[0] || before[i] == -1) continue;
            if(before[i] == 0)      result[2] += 1;
            else if(before[i] == 2) result[3] += 1;
        }
        result[1] = nextList[result[0]].size() - result[2] - result[3];

        int[] answer = result;
        return answer;
    }

    void findGenNode() {
        for(int i = 1; i < length; i++) {
            if(nextList[i].size() >= 2 && before[i] == 0) {
                result[0] = i;
                return;
            }
        }
    }

    int findMax(int[][] edges) {
        int max = 0;
        for(int i = 0; i < edges.length; i++) {
            max = Math.max(max, edges[i][0]);
            max = Math.max(max, edges[i][1]);
        }
        return max;
    }

    void setTarget(int[][] edges) {
        for(int i = 0; i < edges.length; i++) {
            before[edges[i][0]] = 0;
            before[edges[i][1]] = 0;
        }
    }
}