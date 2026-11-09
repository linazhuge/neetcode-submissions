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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        ListNode newHead = new ListNode(0);
        ListNode node = newHead;

        for (int i=0; i < list.size(); i++) {
            if (i == list.size() - n) continue;
            node.next = list.get(i);
            node = node.next;
        }
        node.next = null;

        return newHead.next;
    }
}
