package daily_challenge;

public class P34 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = binarySearch(nums, 0, nums.length - 1, target);
            int left, right;
            left = right = index;

            while(left > 0 && nums[left - 1] == target) {
                left--;
            }
            while(right < nums.length - 1 && nums[right + 1] == target) {
                right--;
            }

            return new int[]{left, right};
        }

        private int binarySearch(int[] nums, int left, int right, int target) {
            if(left > right) {
                return -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target);
            }
            return binarySearch(nums, mid + 1, right, target);
        }
    }


    class Solution1 {
        public int[] searchRange(int[] nums, int target) {

            int firstOccurrence = this.findBound(nums, target, true);

            if (firstOccurrence == -1) {
                return new int[]{-1, -1};
            }

            int lastOccurrence = this.findBound(nums, target, false);

            return new int[]{firstOccurrence, lastOccurrence};
        }

        private int findBound(int[] nums, int target, boolean isFirst) {
            int N = nums.length;
            int begin = 0, end = N - 1;

            while (begin <= end) {

                int mid = (begin + end) / 2;

                if (nums[mid] == target) {

                    if (isFirst) {

                        // This means we found our lower bound.
                        if (mid == begin || nums[mid - 1] != target) {
                            return mid;
                        }

                        // Search on the left side for the bound.
                        end = mid - 1;

                    } else {

                        // This means we found our upper bound.
                        if (mid == end || nums[mid + 1] != target) {
                            return mid;
                        }

                        // Search on the right side for the bound.
                        begin = mid + 1;
                    }

                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }

            return -1;
        }
    }


    class Solution3 {
        public int[] searchRange(int[] nums, int target) {
            int left = binarySearch(nums, 0, nums.length - 1, target, true);

            if(left == -1) {
                return new int[]{-1, -1};
            }

            int right = binarySearch(nums, 0, nums.length -1, target, false);

            return new int[]{left, right};
        }

        private int binarySearch(int[] nums, int left, int right, int target, boolean isFirst) {
            if(left > right) {
                return -1;
            }
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                if (isFirst) {
                    if (left == mid || nums[mid - 1] != target) {
                        return mid;
                    }
                    return binarySearch(nums, left, mid - 1, target, isFirst);
                } else {
                    if (right == mid || nums[mid + 1] != target) {
                        return mid;
                    }
                    return binarySearch(nums, mid + 1, right, target, isFirst);
                }
            }
            if (nums[mid] > target) {
                return binarySearch(nums, left, mid - 1, target, isFirst);
            }
            return binarySearch(nums, mid + 1, right, target, isFirst);
        }
    }
}
