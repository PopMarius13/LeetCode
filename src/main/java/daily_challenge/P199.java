    //package daily_challenge;
    //
    //import javax.swing.tree.TreeNode;
    //import java.util.ArrayList;
    //import java.util.HashMap;
    //import java.util.List;
    //import java.util.Map;
    //import java.util.stream.Collectors;
    //
    //public class P199 {
    //
    //    /
    //      Definition for a binary tree node.
    //      public class TreeNode {
    //          int val;
    //          TreeNode left;
    //          TreeNode right;
    //          TreeNode() {}
    //          TreeNode(int val) { this.val = val; }
    //          TreeNode(int val, TreeNode left, TreeNode right) {
    //              this.val = val;
    //              this.left = left;
    //              this.right = right;
    //          }
    //      }
    //     /
    //    class Solution {
    //        public List<Integer> rightSideView(TreeNode root) {
    //
    //            Map<Integer, Integer> rightElementByDepth = new HashMap<>();
    //            inorder(root, rightElementByDepth, 0);
    //            return new ArrayList<>(rightElementByDepth.values());
    //
    //        }
    //
    //        public void inorder(TreeNode root, Map<Integer, Integer> rebd, int depth) {
    //            if(root != null) {
    //                inorder(root.left, rebd, depth + 1);
    //                rebd.put(depth, root.val);
    //                inorder(root.right, rebd, depth + 1);
    //            }
    //        }
    //    }
    //
    //    class Solution1 {
    //        private  List<Integer> nodeRight = new ArrayList<>();
    //
    //        public List<Integer> rightSideView(TreeNode root) {
    //            helper(root , 0);
    //
    //            return nodeRight;
    //        }
    //
    //        public void helper(TreeNode root , int rank){
    //            if(root != null){
    //                if(nodeRight.size() <= rank)
    //                    nodeRight.add(root.val);
    //                else
    //                    nodeRight.set(rank , root.val);
    //
    //                helper(root.left , rank + 1);
    //                helper(root.right , rank + 1);
    //            }
    //        }
    //    }
    //}
