package programmers;

public class programmers_양궁대회 {
    int max;
    int[] result;

    public int[] solution(int n, int[] info) {
        dfs(n, info, new int[11], 0);

        if(max <= 0) result = new int[] {-1};
        int[] answer = result;
        return answer;
    }

    void dfs(int n, int[] info, int[] rion, int depth) {
        if(n == 0) {
            int diff = calcPoint(rion, info);
            if(max < diff) {
                max = diff;
                result = copyArr(rion);
            } else if(max == diff && max != 0) {
                if(checkLowNum(rion)) {
                    result = copyArr(rion);
                }
            }
            return;
        }

        for(int i = depth; i <= 9; i++) {
            if(n > info[i]) {
                rion[i] = info[i] + 1;
                n -= rion[i];
                dfs(n, info, rion, i + 1);
                n += rion[i];
                rion[i] = 0;
            }
        }
        rion[10] = n;
        dfs(0, info, rion, 10);
        rion[10] = 0;
    }

    int calcPoint(int[] rion, int[] apeach) {
        int rPoint = 0, aPoint = 0;
        for(int i = 0; i <= 10; i++) {
            if(apeach[i] == 0 && rion[i] == 0)   continue;
            if(apeach[i] >= rion[i]) {
                aPoint += 10 - i;
            } else {
                rPoint += 10 - i;
            }
        }
        return rPoint - aPoint;
    }

    int[] copyArr(int[] origin) {
        int[] newArr = new int[origin.length];
        for(int i = 0; i < origin.length; i++) {
            newArr[i] = origin[i];
        }
        return newArr;
    }

    boolean checkLowNum(int[] newArr) {
        for(int i = 10; i >= 0; i--) {
            if(newArr[i] > result[i])   return true;
            else if(newArr[i] < result[i])   return false;
        }
        return false;
    }
}