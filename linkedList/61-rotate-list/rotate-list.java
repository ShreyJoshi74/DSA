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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
     
        
        
        int length= 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;

        }
        System.out.println(length);
        ListNode back = head;
        ListNode front = head;
        int target = 0;
        k = k % length;
        System.out.println(k);
        if(k == 0) return head;
        while(target < k && front != null){
            target++;
            front = front.next;
        }
        while(front != null && front.next!= null){
            back = back.next;
            front = front.next;
        }
        
        //f(front == back) return back;
        ListNode newHead = back.next;
        back.next = null;
        front.next= head;
        return newHead; 
        


    }
}