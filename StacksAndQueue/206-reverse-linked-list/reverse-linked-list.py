# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if head == None or head.next== None:
            return head
        return self._reverse(head,None)
        
    def _reverse(self,head,prev):
        if(head == None):
            return prev
        front = head.next
        head.next = prev
        return self._reverse(front,head)