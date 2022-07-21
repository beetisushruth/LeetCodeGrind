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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode auxHead = new ListNode(-1, head);
        ListNode node = auxHead;
        int i = 1;
        while(i < left) {
            node = node.next;
            i++;
        }
        ListNode beforeLeft = node;
        node = node.next;
        ListNode beforeRight = node;
        ListNode prev = new ListNode(-1);
        while(i <= right) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            i++;
        }
        beforeLeft.next = prev;
        beforeRight.next = node;
        return auxHead.next;
    }
}