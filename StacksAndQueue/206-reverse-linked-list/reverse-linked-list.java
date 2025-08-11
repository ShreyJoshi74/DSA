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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        head = rev(head,null);
        return head;

    }
    public ListNode rev(ListNode head,ListNode prev){
        if(head == null) return prev;
        ListNode front = head.next;
        head.next = prev;
        head = rev(front,head);
        return head;
    }
}