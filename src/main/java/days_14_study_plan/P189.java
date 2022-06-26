package days_14_study_plan;

import java.util.Arrays;

public class P189 {

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            if(n == k) {
                return ;
            }

            int left = 0, right = n - k;
            while(left < k) {
                int aux = nums[left];
                nums[left++] = nums[right];
                nums[right++] = aux;
            }
        }
    }

    class Solution1 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            swap(nums, 0, n - 1);
            System.out.println(Arrays.toString(nums));
            swap(nums, 0, k - 1);
            swap(nums, k, n - 1);
        }

        private void swap(int[] nums, int left, int right) {
            while (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                ++left;
                --right;
            }
        }
    }
}
