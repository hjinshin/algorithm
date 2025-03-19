package programmers;

import java.util.*;

public class programmers_신고_결과_받기 {
    Map<String, Integer> idMap = new HashMap<>();
    boolean[][] reportId;
    int[] count;
    int[] mail;
    int size;

    public int[] solution(String[] id_list, String[] report, int k) {
        size = id_list.length;
        init(id_list);
        mail = new int[size];
        count = new int[size];
        reportId = new boolean[size][size];


        reportProcessing(report);
        countMail(k);

        int[] answer = mail;
        return answer;
    }

    public void init(String[] idList) {
        for(int i = 0; i < size; i++) {
            idMap.put(idList[i], i);
        }
    }

    public void reportProcessing(String[] report) {
        for(String r : report) {
            String[] names = r.split(" ");
            int reporterId = idMap.get(names[0]);
            int reportedId = idMap.get(names[1]);
            if(!reportId[reportedId][reporterId]) {
                count[reportedId]++;
                reportId[reportedId][reporterId] = true;
            }
        }
    }

    public void countMail(int k) {
        for(int i = 0; i < size; i++) {
            if(count[i] >= k) {
                for(int j = 0; j < size; j++) {
                    if(reportId[i][j]) {
                        mail[j]++;
                    }
                }
            }
        }
    }
}