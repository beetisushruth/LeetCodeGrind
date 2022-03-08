/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowptr = head;
        ListNode fastptr = head;
        while(slowptr != null && fastptr != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next;
            if(fastptr == null) return false;
            fastptr = fastptr.next;
            if(fastptr == slowptr) break;
        }
        return slowptr != null && fastptr != null;
    }
}