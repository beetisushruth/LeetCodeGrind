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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode aux_head = new ListNode(-101);
        aux_head.next = head;
        ListNode node = head;
        ListNode prev = aux_head;
        ListNode prevCorrectNode = aux_head;
        while(node != null) {
            if(prev.val == node.val) {
                while(node != null && prev.val == node.val) {
                    node = node.next;
                }
                prevCorrectNode.next = node;
            } else {
                prevCorrectNode = prev;
            }
            prev = node;
            if(node != null) node = node.next;
        }
        return aux_head.next;
    }
}