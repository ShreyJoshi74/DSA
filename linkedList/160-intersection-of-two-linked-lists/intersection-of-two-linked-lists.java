/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ac=0;
        int bc=0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null){
            ac++;
            tempA = tempA.next;
        }
        while(tempB != null){
            bc++;
            tempB = tempB.next;
        }
        while(ac > bc){
            ac--;
            headA = headA.next;
        }

        while(bc > ac){
            bc--;
            headB = headB.next;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}