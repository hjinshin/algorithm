package programmers;

public class programmers_완전_범죄 {
    static final int INF = 121;

    public int solution(int[][] info, int n, int m) {
        int [][] dp = new int[info.length + 1][m];
        for(int i = 0; i <= info.length; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;
        for(int i = 1; i <= info.length; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for(int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                if(j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }

        int answer = 121;
        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }
        if(answer >= n) {
            answer = -1;
        }
        return answer;
    }
}