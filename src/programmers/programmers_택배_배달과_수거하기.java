package programmers;

import java.util.*;

class programmers_택배_배달과_수거하기 {
    Stack<House> dStack = new Stack<>();
    Stack<House> pStack = new Stack<>();
    long result;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        init(deliveries, pickups, n);

        while(!dStack.empty() || !pStack.empty()) {
            int dIdx = loading(cap, dStack);
            int pIdx = loading(cap, pStack);
            result += 2 * Math.max(dIdx, pIdx);
        }


        long answer = result;
        return answer;
    }

    void init(int[] deliveries, int[] pickups, int n) {
        for(int i = 0; i < n; i++) {
            if(deliveries[i] != 0) dStack.push(new House(i, deliveries[i]));
            if(pickups[i] != 0) pStack.push(new House(i, pickups[i]));
        }
    }

    int loading(int cap, Stack<House> stack) {
        if(stack.empty()) return 0;
        int position = stack.peek().position;
        while(cap > 0 && !stack.empty()) {
            House house = stack.peek();
            if(house.num > cap) {
                house.num -= cap;
                break;
            }
            cap -= house.num;
            stack.pop();
        }
        return position + 1;
    }


    class House {
        int position;
        int num;
        public House(int position, int num) {
            this.position = position;
            this.num = num;
        }
    }
}