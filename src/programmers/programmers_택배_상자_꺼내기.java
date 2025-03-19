package programmers;

public class programmers_택배_상자_꺼내기 {
    public int solution(int n, int w, int num) {
        int numPos = findPosition(w, num);
        int nPos = findPosition(w, n);
        int numFloor = getFloor(w, num);
        int nFloor = getFloor(w, n);


        int answer = calc(nPos, numPos, nFloor, numFloor) + 1;
        return answer;
    }


    public int findPosition(int w, int num) {
        int newNum = num - 1;
        int remain = newNum % w;
        int div = newNum / w;
        if(div % 2 == 0 && num % w == 1) return 1;
        if(div % 2 == 0 && num % w == 0) return w;
        if(div % 2 == 1) return w - remain;
        return remain + 1;
    }

    public int getFloor(int w, int num) {
        int remain = num % w;
        int div = num / w;
        if(remain != 0) return div + 1;
        return div;
    }

    public int calc(int nPos, int numPos, int nFloor, int numFloor) {
        if(nFloor % 2 == 0) {
            if(nPos <= numPos)  return nFloor - numFloor;
            return nFloor - numFloor - 1;
        }
        if(nPos >= numPos)  return nFloor - numFloor;
        return nFloor - numFloor - 1;
    }
}