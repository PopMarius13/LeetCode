package daily_challenge;

import java.util.*;

public class P315 {

    class Solution { // too slow
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            int count;

            for (int i = 0; i < n; i++) {
                count = 0;
                for (int j = i + 1; j < n; j++) {
                    if(nums[i] > nums[j]) {
                        count++;
                    }
                }
                ans.add(count);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println(sol.countSmaller(new int[]{5,2,6,1}));
    }

    static class Solution1 {

        private int size = 2 * 10000 + 1;
        private int offset = 10000;
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length - 1;
            int[] tree = new int[size * 2]; // 20002 - 40002 -> interval 1 (all numbers), 10001 - 20001 -> interval 2
            List<Integer> result = new LinkedList<>();

            for(int i = n; i >= 0; i--) {
                int newNumber = nums[i] + offset;
                int smaller_count = query(0, newNumber, tree);
                result.add(smaller_count);
                update(newNumber, 1, tree);
            }

            Collections.reverse(result);
            return result;
        }


        private int query(int left, int right, int[] tree) {
            int result = 0;
            left += size;   /// shift the index to the leaf
            right += size;

            while(left < right) {
                if(left % 2 == 1) {
                    result += tree[left];
                    left++;
                }
                left /= 2;

                if(right % 2 == 1) {
                    right--;
                    result += tree[right];
                }
                right /= 2;
            }
            return result;
        }

        private void update(int index, int value, int[] tree) {
            index += size;
            tree[index] += value;

            while(index > 1) {
                index /= 2;
                tree[index] = tree[index * 2] + tree[index * 2 + 1];
                System.out.println(index + " --- " + tree[index]);
            }
        }
    }


    static class Solution2 {
        private int offset = 10000;
        private int size = 2 * 10000 + 2;
        private int[] tree = new int[size];

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new LinkedList<>();
            int n = nums.length;

            for(int i = n - 1; i >= 0; i--) {
                int smaller_count = query(nums[i] + offset);
                result.add(smaller_count);
                update(nums[i] + offset, 1);
            }
            Collections.reverse(result);
            return result;
        }

        private void update(int index, int value) {
            index++;
            System.out.println(index);
            while(index < size) {
                tree[index] += value;
                System.out.println(index + "  ->  " + tree[index]);
                index += index & -index;
            }
            System.out.println("---------");
        }

        private int query(int index) {
            int result = 0;
            while(index >= 1) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }

    }

    static class Solution3 {
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int[] indices = new int[n];

            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            mergeSort(indices, 0, n, result, nums);

            List<Integer> resultToReturn = new ArrayList<>(n);
            for(int i : result) {
                resultToReturn.add(i);
            }
            return resultToReturn;
        }

        private void mergeSort(int[] indices, int left, int right, int[] result, int[] nums) {
            if (right - left <= 1) {
                return;
            }
            int mid = (left + right) / 2;
            mergeSort(indices, left, mid, result, nums);
            mergeSort(indices, mid, right, result, nums);
            merge(indices, left, right, mid, result, nums);
        }

        private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
            int i = left;
            int j = mid;
            List<Integer> temp = new ArrayList<>(right - left);
            while (i < mid && j < right) {
                if(nums[indices[i]] <= nums[indices[j]]) {
                    result[indices[i]] += j - mid;
                    temp.add(indices[i]);
                    i++;
                } else {
                    temp.add(indices[j]);
                    j++;
                }
            }

            while (i < mid) {
                result[indices[i]] += j - mid;
                temp.add(indices[i]);
                i++;
            }

            while (j < right) {
                temp.add(indices[j]);
                j++;
            }

            for(int k = left; k < right; k++) {
                indices[k] = temp.get(k - left);
            }
        }
    }
}
