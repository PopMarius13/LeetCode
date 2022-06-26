package daily_challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1423 {

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            if (k == cardPoints.length) {
                return Arrays.stream(cardPoints).sum();
            }
            int sum = 0, max;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i];
            }
            max = sum;

            for (int i = cardPoints.length - 1; i > cardPoints.length - k - 1; i--) {
                int index = k - (cardPoints.length - i);
                sum += cardPoints[i] - cardPoints[index];
                max = Math.max(max, sum);
            }

            return max;
        }
    }
}
