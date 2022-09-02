package daily_challenge;

import java.util.*;

public class P637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            Map<Integer, List<Double>> sums = new HashMap<>();
            calculateSums(root, sums, 0);
            List<Double> ans = new ArrayList<>();
            int max = Collections.max(sums.keySet());
            for (int i = 0; i <= max; i++) {
                System.out.println(Arrays.toString(sums.get(i).toArray()));
                Double average = (double) (sums.get(i).get(1) / sums.get(i).get(0));
                ans.add(average);
            }
            return ans;
        }

        public void calculateSums(TreeNode root, Map<Integer, List<Double>> sums, int level) {
            if (root == null) return;
            List<Double> newSum = sums.getOrDefault(level, new ArrayList<>());
            if (newSum == null) {
                newSum.add(1.0);
                newSum.add((double) root.val);
            } else {
                newSum.set(0, newSum.get(0) + 1);
                newSum.set(1, newSum.get(1) + root.val);
            }
            sums.put(level, newSum);
            calculateSums(root.left, sums, level + 1);
            calculateSums(root.right, sums, level + 1);
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Solution1 {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Integer> count = new ArrayList<>();
            List<Double> res = new ArrayList<>();
            average(root, 0, res, count);
            for (int i = 0; i < res.size(); i++)
                res.set(i, res.get(i) / count.get(i));
            return res;
        }

        public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
            if (t == null)
                return;
            if (i < sum.size()) {
                sum.set(i, sum.get(i) + t.val);
                count.set(i, count.get(i) + 1);
            } else {
                sum.add(1.0 * t.val);
                count.add(1);
            }
            average(t.left, i + 1, sum, count);
            average(t.right, i + 1, sum, count);
        }
    }

}
