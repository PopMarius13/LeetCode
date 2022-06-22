package daily_challenge;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class P215 {

    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

            for (int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.poll();
        }
    }

    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }


    class QuickSelect {
        int[] nums;

        public void swap(int index1, int index2) {
            int tmp = this.nums[index1];
            this.nums[index1] = this.nums[index2];
            this.nums[index2] = tmp;
        }
        public int partition(int left, int right, int pivot_index) {
            int pivot = this.nums[pivot_index];

            swap(pivot_index, right);
            int store_index = left;

            for(int i = left; i < right; i++) {
                if(this.nums[i] < pivot) {
                    swap(store_index++, i);
                }
            }
            swap(store_index, right);
            return store_index;
        }

        public int quickSelect(int left, int right, int k_smallest) {
            if (left == right) {
                return this.nums[left];
            }

            Random random_pivot = new Random();
            int pivot_index = left + random_pivot.nextInt(right - left);

            pivot_index = partition(left, right, pivot_index);

            if(k_smallest == pivot_index) {
                return this.nums[k_smallest];
            } else if (k_smallest < pivot_index) {
                return quickSelect(left, pivot_index - 1, k_smallest);
            }
            return quickSelect(pivot_index + 1, right, k_smallest);
        }

        public int findKthLargest(int[] nums, int k) {
            this.nums = nums;
            int size = nums.length; // size - k -> smallest k position
            return quickSelect(0, size - 1, size - k);
        }
    }
}
