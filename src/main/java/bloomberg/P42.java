package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P42 {

    class Solution {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int ans = 0;
            int size = height.length;

            int[] left_max = new int[size];
            int[] right_max = new int[size];
            left_max[0] = height[0];
            right_max[size - 1] = height[size - 1];
            for (int i = 1; i < size; i++) {
                left_max[i] = Math.max(height[i], left_max[i - 1]);
            }
            for (int i = size - 2; i >= 0; i--) {
                right_max[i] = Math.max(height[i], right_max[i + 1]);
            }
            for (int i = 1; i < size - 1; i++) {
                ans += Math.min(left_max[i], right_max[i]) - height[i];
            }

            return ans;
        }
    }

    class Solution1 {
        public int trap(int[] height) {
            int ans = 0, current = 0;
            Stack<Integer> stack = new Stack<>();

            while (current < height.length) {
                while (!stack.empty() && height[current] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                    int distance = current - stack.peek() - 1;
                    int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                    ans += distance * bounded_height;
                    System.out.println(stack);
                    System.out.println(ans);
                    System.out.println();
                }
                stack.push(current++);
                System.out.println(stack);
            }
            return ans;
        }

    }

    class Solution2 {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0;
            int right = height.length - 1;
            int left_max = 0;
            int right_max = 0;

            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= left_max) {
                        left_max = height[left];
                    } else {
                        ans += left_max - height[left];
                    }
                    left++;
                } else {
                    if (height[right] >= right_max) {
                        right_max = height[right];
                    } else {
                        ans += right_max - height[right];
                    }
                    right--;
                }
            }

            return ans;
        }

    }
}
