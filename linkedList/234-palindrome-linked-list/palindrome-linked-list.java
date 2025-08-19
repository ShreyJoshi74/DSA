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
    public ListNode reverseList(ListNode head){
        if(head == null) return head;
        ListNode prev = head;
        
        ListNode current = head.next;
        prev.next = null;
        while(current != null){
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;

        }
        ListNode tail = reverseList(slow.next);
        slow.next = null;
        while(head != null && tail != null){
            
            if(head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
        
    }
}