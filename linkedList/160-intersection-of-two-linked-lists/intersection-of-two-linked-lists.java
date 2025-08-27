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
        Set<ListNode> ls = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null || tempB != null){
            if(tempA != null && ls.contains(tempA))  return tempA;
            ls.add(tempA);
            if(tempB != null && ls.contains(tempB))  return tempB;
            ls.add(tempB);
            if(tempA != null)tempA = tempA.next;
            if(tempB != null)tempB = tempB.next;
            
            
        }
        return null;
    }
}