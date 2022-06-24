package daily_challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P630 {

    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a,b)->(a[1]-b[1]));
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->b[0]-a[0]);
            int time = 0;
            for (int[] c : courses) {
                int duration = c[0];
                int lastDay = c[1];
                if (time + duration <= lastDay) {
                    time += duration;
                    q.offer(c);
                } else if (!q.isEmpty() && q.peek()[0] > duration) {
                    time = time - q.poll()[0] + duration;
                    q.offer(c);
                }
            }
            return q.size();
        }
    }
}
