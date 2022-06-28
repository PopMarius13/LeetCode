package leetcode_75_study_plan;

public class P206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode left = null;

        public ListNode reverseList(ListNode head) {
            if(head == null)
                return null;

            ListNode newNod = head.next;
            head.next = null;
            left = head;

            head = recursivReverse(newNod);

            return head;
        }

        public ListNode recursivReverse(ListNode right ){
            if(right == null)
                return left;

            ListNode newNod = right.next;

            right.next = left;
            left = right;

            return recursivReverse(newNod);
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }

}
