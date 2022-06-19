package leetcode_75_study_plan;

import java.util.Arrays;

public class P1480 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n = new int[]{1,2,3,4,5};
        int[] res = s.runningSum(n);
        System.out.println(Arrays.toString(res));
    }


    static class Solution {
        public int[] runningSum(int[] nums) {
            int[] result = new int[nums.length];
            result[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] + nums[i];
            }

            return result;
        }
    }

}
