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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;

        ListNode node = new ListNode(0);
        head = node;

        while (left <= right) {
            node.next = list.get(left);
            node = node.next;
            if (left != right) {
                node.next = list.get(right);
                node = node.next;
            }
            left++;
            right--;
        }

        node.next = null;

        head = head.next;
    }
}
