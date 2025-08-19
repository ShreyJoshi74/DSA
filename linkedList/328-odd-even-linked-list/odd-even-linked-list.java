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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head,fast = head.next;
        ListNode oddHead = slow,evenHead = fast;
        ListNode odd = head,even = fast;
        while(fast != null && fast.next != null){
            slow = slow.next.next;
            fast = fast.next.next;
            odd.next = slow;
            even.next = fast;
            odd = odd.next;
            even = even.next;

        }
        odd.next = evenHead;
        return oddHead;
    }
}