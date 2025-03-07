package programmers;

import java.util.*;

public class programmers_주차_요금_계산 {
    Map<Integer, Integer> carMap = new TreeMap<>();
    Map<Integer, Integer> recordMap = new TreeMap<>();
    int defaultTime, defaultFee, unitTime, unitFee;

    public int[] solution(int[] fees, String[] records) {
        init(fees);
        for(String record : records) {
            String[] r = record.split(" ");
            int time = calcTime(r[0]);
            int carId = Integer.parseInt(r[1]);
            if(r[2].equals("IN")) {
                recordMap.put(carId, time);
                if(!carMap.containsKey(carId)) {
                    carMap.put(carId, 0);
                }
            } else {
                int inTime = recordMap.get(carId);
                recordMap.remove(carId);
                Integer sum = carMap.get(carId);
                carMap.put(carId, sum + time - inTime);
            }
        }

        for(Map.Entry<Integer, Integer> entry : recordMap.entrySet()) {
            Integer sum = carMap.get(entry.getKey());
            carMap.put(entry.getKey(), sum + 1439 - entry.getValue());
        }

        int[] answer = new int[carMap.size()];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : carMap.entrySet()) {
            answer[idx++] = calcFee(entry.getValue());
        }

        return answer;
    }

    public void init(int[] fees) {
        defaultTime = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
    }

    public int calcTime(String s) {
        String[] list = s.split(":");
        return 60 * Integer.parseInt(list[0]) + Integer.parseInt(list[1]);
    }

    public int calcFee(int time) {
        if(time <= defaultTime) {
            return defaultFee;
        }
        return defaultFee + (int)Math.ceil((float)(time - defaultTime) / unitTime) * unitFee;
    }
}
