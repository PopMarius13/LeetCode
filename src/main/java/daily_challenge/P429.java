package daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class P429 {

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

    class Solution {
        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            inorder(root, 0);
            return ans;
        }

        public void inorder(Node root, int depth) {
            if(ans.isEmpty() || ans.size() <= depth) {
                ans.add(new ArrayList<>());
            }
            List<Integer> currentList = ans.get(depth);
            currentList.add(root.val);
            for(Node node : root.children) {
                inorder(node, depth + 1);
            }
        }
    }
}
