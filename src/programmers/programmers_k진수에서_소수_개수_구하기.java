package programmers;
import java.util.*;

public class programmers_k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        String converted = convert(n, k);
        String[] list = converted.split("0");
        int answer = checkPrime(list);
        return answer;
    }

    public String convert(int n, int k) {
        String s = "";
        while(n > 0) {
            int remain = n % k;
            n /= k;
            s = remain + s;
        }
        return s;
    }

    public int checkPrime(String[] list) {
        int cnt = 0;
        for(String s : list) {
            if(s.isEmpty()) continue;
            long number = Long.parseLong(s);
            if(isPrime(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrime(long number) {
        if(number <= 1) {
            return false;
        }

        for(double i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}