package daily_challenge;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P630 {

    class Solution {
        public int scheduleCourse(int[][] courses) {

            int[] diff = new int[courses.length];
            int k = 0;
            for(int i = 0; i < courses.length; i++) {
                int d = courses[i][1] - courses[i][0];
                if(d >= 0) {
                    diff[k++] = d;
                }
            }
            System.out.println(Arrays.toString(diff));

            Arrays.sort(diff);
            int sum = 0, ans = 0;
            for(int i = 0; i < diff.length; i++) {
                if(diff[i] - sum > 0) {
                    sum += diff[i];
                    ans++;
                } else {
                    return ans;
                }
            }
            return ans;

        }

    }
}
