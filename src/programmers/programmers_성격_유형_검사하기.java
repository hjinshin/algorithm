package programmers;

import java.util.*;

public class programmers_성격_유형_검사하기 {
    Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        init();

        for(int i = 0; i < choices.length; i++) {
            int num = choices[i];
            calcSurvey(survey[i], num);
        }
        String answer = makeResult();
        return answer;
    }

    public void init() {
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
    }

    public void calcSurvey(String type, int number) {
        if(number == 4) return;
        char[] c = type.toCharArray();
        if(number < 4) {
            int sum = map.get(c[0]);
            map.put(c[0], sum + 4 - number);
        } else {
            int sum = map.get(c[1]);
            map.put(c[1], sum + number - 4);
        }
    }

    public String makeResult() {
        String result = "";
        int R = map.get('R');
        int T = map.get('T');
        int C = map.get('C');
        int F = map.get('F');
        int J = map.get('J');
        int M = map.get('M');
        int A = map.get('A');
        int N = map.get('N');
        if(R >= T)  result += "R";
        else        result += "T";

        if(C >= F)  result += "C";
        else        result += "F";

        if(J >= M)  result += "J";
        else        result += "M";

        if(A >= N)  result += "A";
        else        result += "N";

        return result;

    }
}
