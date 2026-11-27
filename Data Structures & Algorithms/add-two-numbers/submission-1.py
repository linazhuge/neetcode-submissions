# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        node1 = l1
        node2 = l2
        prev = ListNode()
        head = prev
        carry = 0
        while node1 or node2:
            if not node1:
                val1 = 0
            else:
                val1 = node1.val
                node1 = node1.next
            
            if not node2:
                val2 = 0
            else:
                val2 = node2.val
                node2 = node2.next
            
            val = val1 + val2 + carry
            carry = val // 10
            val = val % 10
            curr = ListNode(val)
            prev.next = curr
            prev = curr

        if carry != 0:
            prev.next = ListNode(carry)
        return head.next
