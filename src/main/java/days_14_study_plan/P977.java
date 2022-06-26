package days_14_study_plan;

import java.util.Arrays;

public class P977 {

    class Solution {
        public int[] sortedSquares(int[] nums) {
            if(nums.length == 1) {
                return nums;
            }
            int left, right, index = 0;
            int[] ans = new int[nums.length];

            while (nums[index] < 0) {
                index++;
            }
            left = index;
            right = index + 1;
            index = 0;
            while(left >= 0 && right < nums.length) {
                if(-nums[left] < nums[right]) {
                    ans[index++] = nums[left] * nums[left];
                    left--;
                } else {
                    ans[index++] = nums[right] * nums[right];
                    right++;
                }
            }
            System.out.println(Arrays.toString(ans));
            while(left >= 0) {
                ans[index++] = nums[left] * nums[left];
                left--;
            }

            while(right <= nums.length) {
                ans[index++] = nums[right] * nums[right];
                right++;
            }

            return ans;
        }
    }

}
