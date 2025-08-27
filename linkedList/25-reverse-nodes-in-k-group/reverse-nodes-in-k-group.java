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
    public ListNode reverse(ListNode head,int k){
        if(k == 1) return head;
        int target = 0;
        ListNode prev = null;
        ListNode current = head;
        
        while(target < k && current != null){
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
            target++;

        }
        return prev;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;
        if(k == 1) return head;
        if(head == null || head.next == null) return head;
        while(front != null){
            int target = 0;
            while(target < k && front != null){
                target++;
                front = front.next;
            }
            if(target < k||front == null) return dummy.next;
            ListNode tempBack = back.next;
            ListNode tempFront = front.next;
            back.next = reverse(back.next,k);
            tempBack.next = tempFront;
            back = tempBack;
            front = tempBack;
        }
        return dummy.next;
    }
}