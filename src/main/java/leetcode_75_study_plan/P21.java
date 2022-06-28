package leetcode_75_study_plan;

public class P21 {

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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newL = new ListNode();
            ListNode crossingL = newL;

            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    crossingL.val = l2.val;
                    l2 = l2.next;
                } else {
                    crossingL.val = l1.val;
                    l1 = l1.next;
                }

                if (l1 != null && l2 != null) {
                    crossingL.next = new ListNode();
                    crossingL = crossingL.next;
                }
            }

            while (l1 != null) {
                crossingL.next = new ListNode(l1.val);
                l1 = l1.next;
                crossingL = crossingL.next;
            }

            while (l2 != null) {
                crossingL.next = new ListNode(l2.val);
                l2 = l2.next;
                crossingL = crossingL.next;
            }

            return newL;
        }
    }

    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            else if (l2 == null) {
                return l1;
            }
            else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }
    }
}
