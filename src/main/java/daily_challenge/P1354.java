package daily_challenge;

import java.util.PriorityQueue;

public class P1354 {

    class Solution {
        public boolean isPossible(int[] target) {
            if(target.length == 1){
                return target[0] == 1;
            }
            int sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> b - a);

            for(int i = 0; i < target.length; i++) {
                sum += target[i];
                pq.offer(target[i]);
            }

            while(sum > target.length) {
                int max = pq.poll();
                if(max <= sum/2){
                    return false;
                }
                int rest = sum - max;
                if(rest == 1) {
                    return true;
                }
                int newElement = max % rest;
                if(newElement == 0 || newElement == max) {
                    return false;
                }

                pq.offer(newElement);
                sum -= max - newElement;
            }

            return sum == target.length;
        }
    }

}
