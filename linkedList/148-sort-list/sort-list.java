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
    public  ListNode merge(ListNode head1,ListNode head2){
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head1!= null && head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }
        while(head2 != null){
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }
        return dummy.next;
    }
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode middle = middle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return merge(leftHead,rightHead);
        
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}