package daily_challenge;


import java.util.PriorityQueue;
import java.util.Queue;

public class P1642 {


    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            Queue<Integer> firstDifferences = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] < heights[i + 1]) {
                    int currentDifferent = heights[i + 1] - heights[i];

                    firstDifferences.add(currentDifferent);
                    bricks -= currentDifferent;

                    if (bricks < 0 && ladders == 0) {
                        return i;
                    }

                    if (bricks < 0) {
                        ladders--;
                        bricks += firstDifferences.remove();
                    }
                }
            }

            return heights.length - 1;
        }
    }
}
