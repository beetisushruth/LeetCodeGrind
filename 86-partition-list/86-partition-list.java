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
    public ListNode partition(ListNode head, int x) {
        ListNode aux = new ListNode(-1, head);
        ListNode l = new ListNode(-1);
        ListNode g = new ListNode(-1);
        ListNode gt = g;
        ListNode lt = l;
        ListNode prev = aux;
        ListNode node = head;
        while(node != null) {
            ListNode[] nodes = remove(prev);
            if(node.val < x) {
                lt.next = nodes[0];
                lt = lt.next;
            }
            else {
                gt.next = nodes[0];
                gt = gt.next;
            }
            node = nodes[1];
        }
        lt.next = g.next;
        return l.next;
    }
    
    public ListNode[] remove(ListNode prev) {
        ListNode node = prev.next;
        prev.next = node.next;
        node.next = null;
        return new ListNode[]{node, prev.next};
    }
}