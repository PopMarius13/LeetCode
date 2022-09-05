package bloomberg;

public class P239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int sum = 0;
            int lastNum = 0;
            int max = -30001;
            for()

            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - lastNum;
                lastNum = nums[i];
                if (max < sum) {
                    max = sum;
                }
            }

        }
    }
}
