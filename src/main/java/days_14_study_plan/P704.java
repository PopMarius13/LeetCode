package days_14_study_plan;

public class P704 {

    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        public int binarySearch(int[] nums, int left, int right, int target) {
            if( left > right) {
                return -1;
            }
            int mij = (left + right) / 2;
            if ( nums[mij] == target ) {
                return mij;
            } else if ( nums[mij] > target ) {
                return binarySearch(nums, left, mij - 1, target);
            }
            return binarySearch(nums, mij + 1, right, target);
        }
    }
}
