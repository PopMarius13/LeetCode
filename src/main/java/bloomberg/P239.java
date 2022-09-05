package bloomberg;

import java.util.*;

public class P239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int lastNum = nums[0];
            int length = nums.length;
            int[] ans = new int[length - k];
            int m = 0;

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < k; i++) {
                priorityQueue.add(nums[i]);
            }
            if (priorityQueue.size() > 0) {
                ans[m++] = priorityQueue.peek();
            } else {
                return ans;
            }
            for (int i = k; i < length; i++) {
                priorityQueue.add(nums[i]);
                priorityQueue.remove(lastNum);
                lastNum = nums[i - k];
                if (priorityQueue.size() > 0) {
                    ans[m++] = priorityQueue.peek();
                }
            }
            return ans;
        }
    }


    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            int [] left = new int[n];
            left[0] = nums[0];
            int [] right = new int[n];
            right[n - 1] = nums[n - 1];
            for (int i = 1; i < n; i++) {
                // from left to right
                if (i % k == 0) left[i] = nums[i];  // block_start
                else left[i] = Math.max(left[i - 1], nums[i]);

                // from right to left
                int j = n - i - 1;
                if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
                else right[j] = Math.max(right[j + 1], nums[j]);
            }

            int [] output = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++)
                output[i] = Math.max(left[i + k - 1], right[i]);

            return output;
        }
    }

    class Solution2 {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int [] nums;

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }
            int [] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i  = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
    }
}
