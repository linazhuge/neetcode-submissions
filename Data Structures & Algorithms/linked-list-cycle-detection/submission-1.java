/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode one = head.next;
        if (one == null) return false;
        ListNode two = one.next;

        while (two != null) {
            if (one == two) {
                return true;
            } else {
                one = one.next;
                two = two.next;
                if (two == null) return false;
                two = two.next;
            }
        }

        return false;
    }
}
