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
        int l = 0;
        ListNode node = head;
        ListNode ansHead = null;
        while(node != null) {
            l += 1;
            node = node.next;
        }
        if(l == 0) return null;
        k = k%l;
        node = head;
        while(l - k > 1) {
            node = node.next;
            l--;
        }
        if(node != null) {
            ansHead = node.next;
            node.next = null;
            node = ansHead;
        }
        while(node != null && node.next != null) {
            node = node.next;
        }
        if(node != null) node.next = head;
        return ansHead == null ? head : ansHead;
    }
}