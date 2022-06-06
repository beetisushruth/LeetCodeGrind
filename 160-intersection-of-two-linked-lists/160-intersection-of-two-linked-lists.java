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
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        boolean switchA = false;
        boolean switchB = false;
        while(nodeA != null && nodeB != null) {
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if(nodeA == null) {
                nodeA = headB;
                if(switchA) return null;
                switchA = true;
            }
            if(nodeB == null) {
                nodeB = headA;
                if(switchB) return null;
                switchB = true;
            }
        }
        return null;
    }
}