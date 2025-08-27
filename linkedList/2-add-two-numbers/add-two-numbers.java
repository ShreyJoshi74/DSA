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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempA = l1;
        ListNode tempB = l2;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode output = head;
        while(tempA!= null || tempB != null){
            int valA,valB;
            if(tempA != null) valA = tempA.val;
            else valA = 0;
            if(tempB != null) valB = tempB.val;
            else valB=0;
            int sum = valA + valB + carry;
            System.out.println(sum);
            carry = sum / 10;
            int digit = sum - carry * 10;
            ListNode temp =new ListNode(digit);
            output.next = temp;
            output = output.next;
            if(tempA != null)tempA = tempA.next;
            if(tempB != null) tempB = tempB.next;


        }
        if (carry > 0){
            ListNode last = new ListNode(carry);
            output.next = last;
        }
        return head.next;

    }
}